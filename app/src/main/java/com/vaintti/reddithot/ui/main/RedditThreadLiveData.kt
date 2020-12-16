package com.vaintti.reddithot.ui.main

import androidx.lifecycle.LiveData
import com.vaintti.reddithot.models.RedditThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

class RedditThreadLiveData(value: List<RedditThread>? = null) : LiveData<List<RedditThread>?>(value) {
    companion object {
        private const val BASE_URL = "www.reddit.com"
    }

    private val client = OkHttpClient()
    private val parser = Json { ignoreUnknownKeys = true }

    init {
        getHotThreads()
    }

    private fun getHotThreads() {
        CoroutineScope(Dispatchers.IO).launch {
            // Request
            val url = HttpUrl.Builder()
                .scheme("https")
                .host(BASE_URL)
                .addPathSegment("hot.json")
                .build()
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()

            // Handle response
            val bodyString = response.body!!.string()

            val jsonObject = parser.parseToJsonElement(bodyString).jsonObject
            val threads = jsonObject.get("data")!!.jsonObject.get("children")!!.jsonArray.map {
                parser.decodeFromJsonElement(RedditThread.serializer(), it.jsonObject.get("data")!!)
            }
            withContext(Dispatchers.Main) { value = threads }
        }
    }
}
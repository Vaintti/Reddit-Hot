package com.vaintti.reddithot.models

import kotlinx.serialization.Serializable

@Serializable
data class RedditThread(val title: String, val selftext: String)
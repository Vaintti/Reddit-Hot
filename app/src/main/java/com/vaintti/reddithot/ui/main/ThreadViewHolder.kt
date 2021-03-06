package com.vaintti.reddithot.ui.main

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vaintti.reddithot.databinding.ThreadRowBinding
import com.vaintti.reddithot.models.RedditThread

class ThreadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ThreadRowBinding.bind(itemView)

    fun bind(thread: RedditThread) {
        binding.titleTextView.text = thread.title
        binding.selfTextTextView.text = thread.selftext
        binding.selfTextTextView.visibility = if (thread.selftext.isBlank()) View.GONE else View.VISIBLE
        itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(thread.url))
            itemView.context.startActivity(intent)
        }
    }
}
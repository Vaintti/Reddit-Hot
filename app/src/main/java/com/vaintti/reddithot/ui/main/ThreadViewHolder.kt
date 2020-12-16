package com.vaintti.reddithot.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vaintti.reddithot.databinding.ThreadRowBinding

class ThreadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ThreadRowBinding.bind(itemView)

    fun bind(thread: RedditThread) {
        binding.titleTextView.text = thread.title
        binding.selfTextTextView.text = thread.selftext
    }
}
package com.vaintti.reddithot.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vaintti.reddithot.R

class ThreadAdapter: RecyclerView.Adapter<ThreadViewHolder>() {
    var items = emptyList<RedditThread>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreadViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.thread_row, parent, false)
        return ThreadViewHolder(view)
    }

    override fun onBindViewHolder(holder: ThreadViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.count()
}
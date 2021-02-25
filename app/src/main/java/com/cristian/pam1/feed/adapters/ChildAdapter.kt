package com.cristian.pam1.feed.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.R
import com.cristian.pam1.feed.models.ChildModel
import com.cristian.pam1.feed.viewHolders.ChildModelViewHolder

class ChildAdapter(private val children: List<ChildModel>) : RecyclerView.Adapter<ChildModelViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildModelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_cell_layout, parent, false)
        return ChildModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildModelViewHolder, position: Int) {
        val child = children[position]
        holder.imageView.setImageResource(child.image)
        holder.textView.text = child.title
    }

    override fun getItemCount() = children.size
}
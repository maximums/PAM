package com.cristian.pam1.ui.feed.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.databinding.FeedCellLayoutBinding
import com.cristian.pam1.ui.feed.models.FeedItem
import com.squareup.picasso.Picasso

class FeedItemViewHolder(private val binding: FeedCellLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: FeedItem) {
        binding.childTextView.text = item.title
        Picasso.get().load(item.image).fit().into(binding.childImageView)
        binding.contentDescription.text = item.description
    }
}
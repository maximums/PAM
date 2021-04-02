package com.cristian.pam1.feed.viewHolders

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.R
import com.cristian.pam1.databinding.FeedCellLayoutBinding
import com.cristian.pam1.feed.models.ChildModel

class ChildModelViewHolder(binding: FeedCellLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    var textView: TextView = binding.childTextView
    var imageView: ImageView = binding.childImageView

    fun bind(item: ChildModel) {
        textView.text = item.title
        imageView.setImageResource(R.drawable.l)
    }
}
package com.cristian.pam1.feed.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.R
import com.cristian.pam1.feed.models.ChildModel

class ChildModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var textView: TextView = view.findViewById(R.id.child_textView)
    var imageView: ImageView = view.findViewById(R.id.child_imageView)

    fun bind(item: ChildModel) {
        textView.text = item.title
        imageView.setImageResource(item.image)
    }
}
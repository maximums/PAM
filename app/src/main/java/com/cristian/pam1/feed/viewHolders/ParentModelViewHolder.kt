package com.cristian.pam1.feed.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.R
import com.cristian.pam1.feed.models.ParentModel

class ParentModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var recyclerView: RecyclerView = view.findViewById(R.id.rv_child)
    var textView: TextView = view.findViewById(R.id.textView2)

//    fun bind(item: ParentModel) {
//        textView.text = item.title
//        recyclerView = item.children
//    }
}
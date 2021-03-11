package com.cristian.pam1.feed.viewHolders

import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.R
import com.cristian.pam1.databinding.ParentRecyclerBinding
import com.cristian.pam1.feed.adapters.ChildAdapter
import com.cristian.pam1.feed.models.ParentModel

class ParentModelViewHolder(binding: ParentRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
    var recyclerView: RecyclerView = binding.rvChild
    var textView: TextView = binding.textView2

    fun bind(item: ParentModel) {
        textView.text = item.title
        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                    recyclerView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
            )
            adapter = ChildAdapter(item.children)
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }
    }
}
package com.cristian.pam1.feed.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.databinding.FeedCellLayoutBinding
import com.cristian.pam1.feed.models.ChildModel
import com.cristian.pam1.feed.models.ParentModel
import com.cristian.pam1.feed.viewHolders.ChildModelViewHolder

class ChildAdapter(private var children: List<ChildModel>) : RecyclerView.Adapter<ChildModelViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildModelViewHolder {
        val binding = FeedCellLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChildModelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildModelViewHolder, position: Int) {
        holder.bind(children[position])
    }

    override fun getItemCount() = children.size

    fun updateDataSet(dataSet: Array<ChildModel>) {
        this.children = dataSet.asList()
        notifyDataSetChanged()
    }
}
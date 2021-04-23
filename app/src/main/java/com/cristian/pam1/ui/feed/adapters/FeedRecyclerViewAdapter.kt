package com.cristian.pam1.ui.feed.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.databinding.FeedCellLayoutBinding
import com.cristian.pam1.ui.feed.models.FeedItem
import com.cristian.pam1.ui.feed.viewHolders.FeedItemViewHolder

class FeedRecyclerViewAdapter(private var dataSet:List<FeedItem>) : RecyclerView.Adapter<FeedItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        val binding = FeedCellLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FeedItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    fun updateDataSet(data: List<FeedItem>){
        this.dataSet = data
        notifyDataSetChanged()
    }

}
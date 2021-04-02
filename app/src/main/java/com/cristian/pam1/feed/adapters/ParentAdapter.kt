package com.cristian.pam1.feed.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.databinding.ParentRecyclerBinding
import com.cristian.pam1.feed.models.ParentModel
import com.cristian.pam1.feed.viewHolders.ParentModelViewHolder

class ParentAdapter(private var parents: List<ParentModel>) :
    RecyclerView.Adapter<ParentModelViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentModelViewHolder {
        val binding = ParentRecyclerBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,
            false
        )
        return ParentModelViewHolder(binding)
    }

    override fun getItemCount() = parents.size

    override fun onBindViewHolder(holder: ParentModelViewHolder, position: Int) {
        holder.bind(parents[position])
    }

    fun updateDataSet(dataSet: Array<ParentModel>) {
        this.parents = dataSet.asList()
        notifyDataSetChanged()
    }
}
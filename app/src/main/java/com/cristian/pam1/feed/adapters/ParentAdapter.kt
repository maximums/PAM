package com.cristian.pam1.feed.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.R
import com.cristian.pam1.feed.models.ParentModel
import com.cristian.pam1.feed.viewHolders.ParentModelViewHolder

class ParentAdapter(private val parents: List<ParentModel>) : RecyclerView.Adapter<ParentModelViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentModelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_recycler, parent, false)
        return ParentModelViewHolder(view)
    }

    override fun getItemCount() = parents.size

    override fun onBindViewHolder(holder: ParentModelViewHolder, position: Int) {
        holder.bind(parents[position])
    }
}
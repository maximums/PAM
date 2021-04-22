package com.cristian.pam1.ui.feed.viewHolders

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.R
import com.cristian.pam1.databinding.FeedCellLayoutBinding
import com.cristian.pam1.ui.feed.models.FeedItem
import com.cristian.pam1.ui.view.FragmentProfile
import com.squareup.picasso.Picasso

class FeedItemViewHolder(private val binding: FeedCellLayoutBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item: FeedItem) {
        binding.childTextView.text = item.title
        Picasso.get().load(item.image).placeholder(R.drawable.l).fit().into(binding.childImageView)
        binding.root.setOnClickListener {
            val act = it.context as AppCompatActivity
            act.supportFragmentManager.commit {
                setReorderingAllowed(true)
                this.add(R.id.drawer_layout, FragmentProfile(item))
                addToBackStack(null)
            }
        }
    }

}
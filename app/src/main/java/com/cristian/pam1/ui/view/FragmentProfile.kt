package com.cristian.pam1.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cristian.pam1.R
import com.cristian.pam1.databinding.FragmentProfileBinding
import com.cristian.pam1.ui.feed.models.FeedItem
import com.squareup.picasso.Picasso

class FragmentProfile(private val itm: FeedItem) : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentProfileBinding.inflate(inflater)

        Picasso.get().load(itm.image).placeholder(R.drawable.l).fit().into(binding.img)
        binding.title.text = itm.title
        binding.description.text = itm.description
        binding.rating.text = itm.averageRating
        binding.age.text = itm.ageRatingGuide
        binding.status.text = itm.status

        return binding.root
    }
}
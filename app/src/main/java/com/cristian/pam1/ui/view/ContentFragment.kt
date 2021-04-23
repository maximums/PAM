package com.cristian.pam1.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.databinding.ContentFragmentBinding
import com.cristian.pam1.ui.feed.adapters.FeedRecyclerViewAdapter
import com.cristian.pam1.ui.viewmodel.ContentFragmentViewModel
import com.cristian.pam1.ui.viewmodel.ContentFragmentViewModelFactory
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class ContentFragment : Fragment() {

    private val factory by inject<ContentFragmentViewModelFactory> { parametersOf(this) }

    private lateinit var binding: ContentFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: FeedRecyclerViewAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var contentFragmentViewModel: ContentFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding =  ContentFragmentBinding.inflate(inflater)
        searchInit()
        initRecyclerView()

        contentFragmentViewModel = ViewModelProviders.of(this, factory).get(ContentFragmentViewModel::class.java)
        contentFragmentViewModel.getContent().observe(viewLifecycleOwner, Observer {
            viewAdapter.updateDataSet(it)
        })

        return binding.root
    }

    private fun initRecyclerView() {
        viewManager = LinearLayoutManager(context)
        viewAdapter = FeedRecyclerViewAdapter(listOf())
        recyclerView = binding.feedRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun searchInit() {
        binding.searchButton.setOnClickListener {
            contentFragmentViewModel.searchForContent(binding.input.text.toString())
            binding.input.text.clear() }
    }
}
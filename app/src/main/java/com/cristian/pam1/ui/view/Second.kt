package com.cristian.pam1.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.data.repository.ContentRepository
import com.cristian.pam1.databinding.ActivitySecondBinding
import com.cristian.pam1.ui.view.feed.adapters.FeedRecyclerViewAdapter
import com.cristian.pam1.ui.viewmodel.SecondViewModel
import com.cristian.pam1.ui.viewmodel.SecondViewModelFactory
import kotlinx.android.synthetic.main.nav_header.view.*


class Second : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: FeedRecyclerViewAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var drawer: DrawerLayout
    private lateinit var secondViewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawer = binding.drawerLayout

        val repository = ContentRepository()
        val factory = SecondViewModelFactory(repository)
        initRecyclerView()

        secondViewModel = ViewModelProviders.of(this, factory).get(SecondViewModel::class.java)
        secondViewModel.getContent().observe(this, Observer {
            viewAdapter.updateDataSet(it)
        })

        searchForContent()
    }

    private fun initRecyclerView() {
        viewManager = LinearLayoutManager(this)
        viewAdapter = FeedRecyclerViewAdapter(listOf())
        recyclerView = binding.feedRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun searchForContent() {
        val header = binding.navigation.getHeaderView(0)
        header?.search_button?.setOnClickListener {
            secondViewModel.searchForContent(header.search.text.toString())
            drawer.closeDrawer(GravityCompat.START)
            header.search.text.clear()
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) drawer.closeDrawer(GravityCompat.START)
        else super.onBackPressed()
    }
}
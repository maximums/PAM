package com.cristian.pam1.feed

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.R
import com.cristian.pam1.databinding.ActivitySecondBinding
import com.cristian.pam1.feed.adapters.ParentAdapter
import com.cristian.pam1.feed.fragments.FragmentChat
import com.cristian.pam1.feed.fragments.FragmentProfile
import com.cristian.pam1.feed.fragments.FragmentSettings
import com.cristian.pam1.feed.models.ChildModel
import com.cristian.pam1.feed.models.ParentDataFactory
import com.cristian.pam1.feed.models.ParentModel
import com.cristian.pam1.network.Communication
import com.cristian.pam1.network.Service
import com.cristian.pam1.network.models.SearchResult
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Second : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: ParentAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var drawer: DrawerLayout
    private lateinit var  service: Communication


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawer = binding.drawerLayout
        service = Communication()

        val navigationView: NavigationView = binding.navigation
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_chat -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FragmentChat()).commitNow()
                    Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FragmentProfile()).commit()
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FragmentSettings()).commit()
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_logout -> {
                    Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
                }
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
        viewManager = LinearLayoutManager(this)
        viewAdapter = ParentAdapter(ParentDataFactory.getParents(40))

        recyclerView = binding.feedRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
        getSearchResult("apollo 11", null)

    }

    private fun getSearchResult(term: String, query: Map<String, String>?) {
        GlobalScope.launch {
            kotlin.runCatching {
                service.search(term, query)
            }.onSuccess {
                handleAPIData(it)
            }.onFailure {
                print("||||||||||||||||||||||||||||||||||||||||||||||||||FAILURE||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n$it")
            }
        }
    }

    private fun handleAPIData(data: ArrayList<SearchResult>) {
        val dataSet = data.map{
            ChildModel(
                it.collection.items.href,
                it.collection.items.data[0].title
            )
        }.toTypedArray()

        MainScope().launch {
            viewAdapter.updateDataSet(
                arrayOf(
                    ParentModel(
                    "Title",
                    dataSet.asList()
                    )
                )
            )
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) drawer.closeDrawer(GravityCompat.START)
        else super.onBackPressed()
    }
}
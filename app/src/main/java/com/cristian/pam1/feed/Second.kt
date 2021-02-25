package com.cristian.pam1.feed

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristian.pam1.R
import com.cristian.pam1.feed.adapters.ParentAdapter
import com.cristian.pam1.feed.models.ParentDataFactory

class Second : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var secondRecyclerView: RecyclerView

    private val uri: String = "@drawable/l"

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        viewManager = LinearLayoutManager(this)
        viewAdapter = ParentAdapter(ParentDataFactory.getParents(40))

        recyclerView = findViewById<RecyclerView>(R.id.feed_recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

    fun submit(view: View) {
    }

    override fun onPause() {
        super.onPause()
    }
}
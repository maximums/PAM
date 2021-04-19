package com.cristian.pam1.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.cristian.pam1.R
import com.cristian.pam1.databinding.FragmentHolderActivityBinding


class FragmentHolderActivity : AppCompatActivity() {

    private lateinit var binding: FragmentHolderActivityBinding
    private lateinit var drawer: DrawerLayout
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHolderActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawer = binding.drawerLayout

        navController = findNavController(R.id.fragment)
        binding.navigation.setupWithNavController(navController)

    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) drawer.closeDrawer(GravityCompat.START)
        else super.onBackPressed()
    }
}
package com.inspirecoding.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.inspirecoding.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    // 1
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        // 2
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        // 3
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 4
        navController = Navigation.findNavController(this, R.id.fragmentContainer)

        // 5
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.bmisFragment)
        )

        // 6
        NavigationUI.setupWithNavController(
            toolbar,
            navController,
            appBarConfiguration
        )
    }
}
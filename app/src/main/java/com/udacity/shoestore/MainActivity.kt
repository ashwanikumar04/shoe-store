package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration
            .Builder(
                R.id.listingFragment
            )
            .build()
        setSupportActionBar(toolbar)
        setupWithNavController(toolbar, navController)
        setupActionBarWithNavController(this, navController, appBarConfiguration)
    }
}

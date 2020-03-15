package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
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

        setSupportActionBar(toolbar)
        setupActionBarWithNavController(this, navController)
        setupWithNavController(toolbar, navController)

        // setSupportActionBar(toolbar)

//        val binding: ActivityMainBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_main)
    }


//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(
//            Navigation.findNavController(this, R.id.navHostFragment), drawer_layout)
//    }
}

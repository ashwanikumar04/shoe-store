package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import com.udacity.shoestore.R

class ListingFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listing, container, false)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
            )
        )

       // setupActionBarWithNavController(activity, Navigation.findNavController(view))

        return view
    }
}
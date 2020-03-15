package com.udacity.shoestore.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.handlers.Handlers
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.vm.ShoeViewModel

class ListingFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)
        binding.handler = Handlers()
        return binding.root
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Test", "this is called")
        viewModel.getShoes().observe(viewLifecycleOwner, Observer<List<Shoe>> { shoes ->
            // update UI
            Log.d("Test", shoes.size.toString())
        })
    }
}
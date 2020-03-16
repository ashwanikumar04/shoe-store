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
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.handlers.Handlers
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.vm.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_listing.*


class ListingFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingBinding =
            DataBindingUtil.inflate(
                inflater,
                com.udacity.shoestore.R.layout.fragment_listing,
                container,
                false
            )
        binding.handler = Handlers(activity!!)
        return binding.root
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getShoes().observe(viewLifecycleOwner, Observer<List<Shoe>> { shoes ->
            // update UI
            if (shoes.isEmpty()) {
                no_data_error.visibility = View.VISIBLE
                data.visibility = View.GONE
            } else {
                no_data_error.visibility = View.GONE
                view.visibility = View.VISIBLE

                for (shoe in shoes) {
                    addShoe(shoe)
                }
            }
        })
    }

    private fun addShoe(shoe: Shoe) {
        val shoeBinding: ShoeItemBinding = ShoeItemBinding.inflate(layoutInflater, data, true)
        shoeBinding.data = shoe
    }
}
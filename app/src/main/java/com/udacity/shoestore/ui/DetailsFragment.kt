package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.handlers.Handlers
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.vm.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.handler = Handlers(requireActivity())
        binding.shoe = Shoe("", 0.0, "", "")

        binding.btnAddShoe.setOnClickListener {
            if (isValid(etName, getString(R.string.error_shoe_name))
                && isValid(etSize, getString(R.string.error_shoe_size))
                && isValid(etCompany, getString(R.string.error_shoe_company))
                && isValid(etDescription, getString(R.string.error_shoe_description))
            ) {
                binding.shoe?.let { s -> viewModel.addShoe(s) }
                Navigation.findNavController(it).navigate(R.id.action_details_listing)
            }
        }
        return binding.root
    }


    private fun isValid(et: TextInputEditText,
                        message: String
    ): Boolean {
        if (et.text.toString().isBlank()) {
            et.error = message
            return false
        }
        return true
    }
}

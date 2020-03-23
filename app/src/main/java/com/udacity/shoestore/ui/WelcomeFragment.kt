package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.handlers.Handlers

class WelcomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentWelcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.handler = Handlers(requireActivity())
        return binding.root
    }
}
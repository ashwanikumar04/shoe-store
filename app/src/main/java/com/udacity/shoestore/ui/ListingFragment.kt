package com.udacity.shoestore.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.udacity.shoestore.databinding.FragmentListingBinding
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
        Log.d("Test", "this is called")
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
            Log.d("Test", shoes.size.toString())
        })
    }

    private fun addShoe(shoe: Shoe) {

        val rootView = LinearLayout(context)
        rootView.layoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        rootView.orientation = LinearLayout.VERTICAL

        val name = TextView(context)
        name.text = "Name: " + shoe.name
        val size = TextView(context)
        size.text = "Size: " + shoe.size
        val company = TextView(context)
        company.text = "Company: " + shoe.company
        val description = TextView(context)
        description.text = "Description: " + shoe.description
        rootView.addView(name)
        rootView.addView(size)
        rootView.addView(company)
        rootView.addView(description)
        val separator = TextView(context)
        separator.text = ""
        rootView.addView(separator)

        data.addView(rootView)

    }

}
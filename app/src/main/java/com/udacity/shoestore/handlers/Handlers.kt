package com.udacity.shoestore.handlers

import android.content.Context
import android.util.Patterns
import android.view.View
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.udacity.shoestore.R
import com.udacity.shoestore.ui.InstructionsFragmentDirections

open class Handlers(context: Context) {
    private val current = context
    fun onLogin(view: View,
                etEmail: TextInputEditText,
                etPassword: TextInputEditText
    ) {
        if (etEmail.text.toString().isBlank() || !Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()) {
            etEmail.error = current.getString(R.string.error_email)
            return
        }
        if (etPassword.text.toString().isBlank()) {
            etPassword.error = current.getString(R.string.error_password)
            return
        }
        Navigation.findNavController(view).navigate(R.id.action_log_in)
    }

    fun onInstructions(view: View
    ) {
        Navigation.findNavController(view).navigate(R.id.action_instructions)
    }

    fun onListing(view: View
    ) {
        Navigation.findNavController(view).navigate(InstructionsFragmentDirections.actionListing())
    }

    fun onAddShoe(view: View
    ) {
        Navigation.findNavController(view).navigate(R.id.action_add_details)
    }

    fun cancel(view: View
    ) {
        Navigation.findNavController(view).navigate(R.id.action_details_listing)
    }
}
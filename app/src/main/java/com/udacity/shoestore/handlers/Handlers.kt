package com.udacity.shoestore.handlers

import android.util.Patterns
import android.view.View
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.udacity.shoestore.R
import com.udacity.shoestore.ui.InstructionsFragmentDirections

open class Handlers {

    fun onLogin(view: View,
                etEmail: TextInputEditText,
                etPassword: TextInputEditText
    ) {
        if (etEmail.text.toString().isBlank() || !Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()) {
            etEmail.error = "Email is empty or invalid. "
            return
        }
        if (etPassword.text.toString().isBlank()) {
            etPassword.error = "Password can't be empty."
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
}
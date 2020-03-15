package com.udacity.shoestore.handlers

import android.view.View
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.udacity.shoestore.R

open class LoginHandler {

    fun onLogin(view: View,
                etEmail: TextInputEditText,
                etPassword: TextInputEditText
    ) {
        if (etEmail.text.toString().isBlank()) {
            etEmail.error = "Email can't be empty"
            return
        }
        if (etPassword.text.toString().isBlank()) {
            etPassword.error = "Password can't be empty"
            return
        }
        Navigation.findNavController(view).navigate(R.id.action_log_in)
    }
}
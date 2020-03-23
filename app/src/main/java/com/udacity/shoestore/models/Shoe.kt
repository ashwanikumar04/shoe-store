package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import android.widget.TextView
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.BindingAdapter


@Parcelize
data class Shoe(var name: String,
                var size: Double,
                var company: String,
                var description: String,
                val images: List<String> = mutableListOf()
) : Parcelable {
    companion object {
        @BindingAdapter("android:text")
        @JvmStatic
        fun setText(view: TextView,
                    value: Double
        ) {
            view.text = value.toString()
        }

        @InverseBindingAdapter(attribute = "android:text")
        @JvmStatic
        fun getText(view: TextView): Double {
            return if (!view.text.toString().isBlank()) {
                view.text.toString().toDouble()
            } else {
                0.0
            }
        }
    }
}
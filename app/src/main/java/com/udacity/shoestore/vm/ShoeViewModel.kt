package com.udacity.shoestore.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private lateinit var shoes: MutableLiveData<MutableList<Shoe>>

    fun getShoes(): MutableLiveData<MutableList<Shoe>> {
        if (!::shoes.isInitialized) {
            shoes = MutableLiveData()
            shoes.value = mutableListOf()
        }
        return shoes
    }

    fun addShoe(shoe: Shoe) {
        Log.d("Test", shoe.toString())
        getShoes().value?.add(shoe)
    }
}
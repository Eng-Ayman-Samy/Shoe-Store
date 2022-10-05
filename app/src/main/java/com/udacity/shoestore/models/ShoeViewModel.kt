package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>> = _shoeList
    val newShoe = MutableLiveData<Shoe>().apply {
        this.value = Shoe(
            name = "",
            company = "",
            size = 0.0,
            description = ""
        )
    }
    val size = MutableLiveData<String>().apply { this.value = "25" }

    fun addShoe() {
        val s = size.value?.toDouble() ?: 0.0
        if (newShoe.value != null)
            addShoe(newShoe.value!!.copy(size = s))
    }

    private fun addShoe(shoe: Shoe) {
        if (shoeList.value != null) {
            val list = shoeList.value!!.toMutableList()
            list.add(shoe)
            _shoeList.value = list
        } else {
            val list = mutableListOf<Shoe>()
            list.add(shoe)
            _shoeList.value = list
        }
    }


}

fun List<Shoe>.toStringAsList(): String {
    var s = ""
    if (this.isNotEmpty()) {
        this.forEach {
            s += it.asString()
        }
    }
    return s
}

fun Shoe.asString(): String {
    return "Shoe name:  $name\n" +
            "Company:  $company\n" +
            "Shoe size:  $size\n" +
            "Description:  $description\n"
}
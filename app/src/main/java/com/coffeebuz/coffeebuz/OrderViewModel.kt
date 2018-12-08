package com.coffeebuz.coffeebuz

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    private val _data = MutableLiveData<String>()

    val data: LiveData<String>
        get() = _data

    init {
        _data.value = "Hello, Jetpack!"
    }
}
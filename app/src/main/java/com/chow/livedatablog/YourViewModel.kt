package com.chow.livedatablog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class YourViewModel: ViewModel() {
    private val _data = MutableLiveData<String>()
    val data: LiveData<String> get() = _data

    fun getUsername(name: String) {
        //Notify MutableLiveData that there is new value coming.
        _data.postValue(name)
    }
}
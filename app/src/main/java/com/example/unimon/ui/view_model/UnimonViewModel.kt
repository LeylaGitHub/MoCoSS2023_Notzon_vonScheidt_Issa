package com.example.unimon.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.unimon.data.Unimon
import kotlinx.coroutines.flow.MutableStateFlow

class UnimonViewModel : ViewModel() {
    private var _unimon = MutableStateFlow(Unimon("Test", 1, 100, 100, 100, 100))

    val unimon: LiveData<Unimon> = _unimon.asLiveData()
}
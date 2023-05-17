package com.example.unimon.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

data class Unimon(
    var name: String,
    var level: Int,
)

class UnimonViewModel : ViewModel() {
    private var _unimon = MutableStateFlow(Unimon("Test", 1))

    val unimon: LiveData<Unimon> = _unimon.asLiveData()
    
    fun levelUp() {
        _unimon.update { unimon: Unimon ->
            unimon.copy(name = "Boob", level = unimon.level + 100)
        }
        println(unimon.value!!.level)
        println(unimon.value!!.name)
    }
}
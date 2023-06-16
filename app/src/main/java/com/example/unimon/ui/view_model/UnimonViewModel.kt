package com.example.unimon.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.unimon.data.Unimon
import com.example.unimon.data.levelUp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UnimonViewModel : ViewModel() {
    private var _unimon = MutableStateFlow(Unimon("Test", 1, 100, 100, 100, 100))

    val unimon: LiveData<Unimon> = _unimon.asLiveData()

    fun levelUpUnimon(context: Context) {
        viewModelScope.launch(Dispatchers.IO){
            levelUp(context)
        }
    }
}
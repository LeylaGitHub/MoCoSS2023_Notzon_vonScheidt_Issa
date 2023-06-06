package com.example.unimon.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unimon.data.Unimon
import com.example.unimon.data.UnimonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UnimonViewModel(val repository: UnimonRepository) : ViewModel() {
    private var _unimon = MutableStateFlow(Unimon(1, "Test", 1, 100, 100, 100, 100))

    val unimon: StateFlow<Unimon> = _unimon

    fun levelUp() {
        val unimon = _unimon.value
        val updatedUnimon = _unimon.value.copy(level = unimon.level + 1)

        viewModelScope.launch {
            repository.updateUnimon(updatedUnimon)
        }
    }
}
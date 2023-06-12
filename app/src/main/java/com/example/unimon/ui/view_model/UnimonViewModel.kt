package com.example.unimon.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.unimon.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import com.example.unimon.ui.model.Unimon
import com.example.unimon.ui.model.Background

class UnimonViewModel : ViewModel() {
    private var _unimon = MutableStateFlow(Unimon("Test", 1, 100, 100, 100, 100))
    val unimon: LiveData<Unimon> = _unimon.asLiveData()

    private var defaultBackground = MutableLiveData(Background(R.drawable.unimon___home, "unimon_background_home", R.drawable.unimon_standard, "unimon_standard"))
    var background: LiveData<Background> = defaultBackground
    
    fun levelUp() {
        _unimon.update { unimon: Unimon ->
            unimon.copy(name = "Boob", level = unimon.level + 100)
        }
        println(unimon.value!!.level)
        println(unimon.value!!.name)
    }

    fun changeBackground (buttonState: Boolean) {
        if (buttonState) {
            defaultBackground.value?.homeBackground = R.drawable.unimon___nightsky
            defaultBackground.value?.homeBackgroundContentD = "unimon_background_nightsky"
            defaultBackground.value?.unimonVersion = R.drawable.unimon_schlaf
            defaultBackground.value?.unimonVersionContentD = "unimon_schlaf"
        }
    }
}
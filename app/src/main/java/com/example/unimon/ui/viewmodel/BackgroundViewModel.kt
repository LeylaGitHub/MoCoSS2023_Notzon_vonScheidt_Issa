package com.example.unimon.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.unimon.R
import com.example.unimon.ui.view.MenuPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

data class Background(
    var homeBackground: Int,
    var homeBackgroundContentD: String,
    var unimonVersion: Int,
    var unimonVersionContentD: String
)

class BackgroundViewModel : ViewModel() {
    private var defaultBackground = MutableStateFlow(Background(R.drawable.unimon___home, "unimon_background_home", R.drawable.unimon_standard, "unimon_standard"))
    val background: LiveData<Background> = defaultBackground.asLiveData()

    fun changeBackground (buttonState: Boolean) {
//        "if MenuPoint is clicked"
        if (buttonState) {
            background.update { background: Background ->
                background.copy(
                    homeBackground = R.drawable.unimon___nightsky,
                    homeBackgroundContentD = "unimon_background_nightsky",
                    unimonVersion = R.drawable.unimon_schlaf,
                    unimonVersionContentD = "unimon_schlaf"
                )
            }
        }
    }
}
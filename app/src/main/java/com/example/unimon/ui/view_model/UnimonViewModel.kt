package com.example.unimon.ui.view_model

import com.example.unimon.R
import com.example.unimon.ui.model.Background
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.unimon.data.getUnimonBody
import com.example.unimon.data.getUnimonLevel
import com.example.unimon.data.getUnimonMind
import com.example.unimon.data.getUnimonName
import com.example.unimon.data.getUnimonSleep
import com.example.unimon.data.getUnimonSocial
import com.example.unimon.data.levelUp
import com.example.unimon.data.updateBody
import com.example.unimon.data.updateMind
import com.example.unimon.data.updateSleep
import com.example.unimon.data.updateSocial
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UnimonViewModel(application: Application) : AndroidViewModel(application) {
    val unimonLevel = getUnimonLevel(getApplication<Application>().applicationContext)
    val unimonName = getUnimonName(getApplication<Application>().applicationContext)

    val unimonBody = getUnimonBody(getApplication<Application>().applicationContext)
    val unimonMind = getUnimonMind(getApplication<Application>().applicationContext)
    val unimonSocial = getUnimonSocial(getApplication<Application>().applicationContext)
    val unimonSleep = getUnimonSleep(getApplication<Application>().applicationContext)

    fun decreaseStats() {
        viewModelScope.launch(Dispatchers.IO) {
            updateBody(-1, getApplication<Application>().applicationContext)
            updateMind(-1, getApplication<Application>().applicationContext)
            updateSocial(-1, getApplication<Application>().applicationContext)
            updateSleep(-1, getApplication<Application>().applicationContext)
        }
    }


    fun levelUpUnimon() {
        viewModelScope.launch(Dispatchers.IO) {
            levelUp(getApplication<Application>().applicationContext)
        }
    }

    -------------------------
    fun changeBackground(buttonState: Boolean) {
        if (buttonState) {
            defaultBackground.value = Background(
                R.drawable.unimon___nightsky,
                "unimon_background_nightsky",
                R.drawable.unimon_schlaf,
                "unimon_schlaf"
            )
        }
    }
}
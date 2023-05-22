package com.example.unimon.ui

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Date
import java.util.concurrent.TimeUnit

data class Unimon(
    var name: String,
    var level: Int,
    var body: Int,
    var mind: Int,
    var social: Int,
    var sleep: Int,
    var bodyTimeStamp: Date,
    var mindTimeStamp: Date,
    var socialTimeStamp: Date,
    var sleepTimeStamp: Date
)

class UnimonViewModel : ViewModel() {
    val now =  Date()
    private var _unimon = MutableStateFlow(Unimon(
        "Test", 1, 100, 100, 100, 100, now, now, now, now
    ))

    val unimon: LiveData<Unimon> = _unimon.asLiveData()

    fun levelUp() {
        _unimon.update { unimon: Unimon ->
            unimon.copy(name = "Boob", level = unimon.level + 100)
        }
        println(unimon.value!!.level)
        println(unimon.value!!.name)
    }
}
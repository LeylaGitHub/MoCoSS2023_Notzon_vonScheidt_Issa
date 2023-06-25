package com.example.unimon

import android.app.Application
import androidx.room.Room
import com.example.unimon.data.QuestionDatabase

class UnimonApplication : Application() {

    val questionDatabase by lazy {
        Room.databaseBuilder(this, QuestionDatabase::class.java, "question-database")
    }
}
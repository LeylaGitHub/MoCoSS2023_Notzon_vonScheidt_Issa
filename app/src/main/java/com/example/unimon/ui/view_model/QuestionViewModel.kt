package com.example.unimon.ui.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.unimon.data.Question
import com.example.unimon.data.QuestionDao
import com.example.unimon.data.QuestionDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionViewModel(application: Application) : AndroidViewModel(application) {
    private val questionDao: QuestionDao

    fun getQuestion(category: String): Question {
        // Debug Questions

        return when (category) {
            "Mathe" -> questionMathe
            "Softwaretechnik" -> questionSoftwaretechnik
            "MobileComputing" -> questionMoCo
            else -> questionMathe
        }

//        return questionDao.getQuestionByCategory(category)
    }

    init {
        val database = QuestionDatabase.getInstance(application.applicationContext)
        questionDao = database.QuestionDao()
        //insertQuestions()
    }

    fun insertQuestions() {
        viewModelScope.launch(Dispatchers.Default) {
            questionDao.insertQuestion(questionMathe)
            questionDao.insertQuestion(questionSoftwaretechnik)
            questionDao.insertQuestion(questionMoCo)
        }
    }

    val questionMathe = Question(
        1,
        "Mathe",
        "Wie lautet die erste binomische Formel?",
        "(a-b)^2",
        "(a+b)^2",
        "(a+b)(a+b)",
        2,
        false,
        50
    )

    val questionSoftwaretechnik = Question(
        2,
        "Softwaretechnik",
        "Wofür steht der Begriff MOOS?",
        "Methodische Objekt-orientierte Softwareentwicklung",
        "Mathematische Objekt-orientierte Softwareentwicklung",
        "Methodische Objekt-orientierte Softwarespezifikation",
        1,
        false,
        50
    )

    val questionMoCo = Question(
        3,
        "MobileComputing",
        "Wofür steht der Begriff DAO?",
        "Daten Aufrufoperationen",
        "Decimal Access Orientiation",
        "Data Access Object",
        3,
        false,
        50
    )
}
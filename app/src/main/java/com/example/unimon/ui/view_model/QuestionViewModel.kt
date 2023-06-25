package com.example.unimon.ui.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.unimon.data.Question
import com.example.unimon.data.QuestionDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionViewModel(application: Application) : AndroidViewModel(application) {
    val questionDao = QuestionDatabase.getInstance(application.applicationContext).QuestionDao()

    fun getQuestion(category: String): Question {
        return questionDao.getQuestionByCategory(category)
    }

    fun insertQuestions(){
        viewModelScope.launch(Dispatchers.IO){
            questionDao.insertQuestion(questionMathe)
            questionDao.insertQuestion(questionSoftwaretechnik)
            questionDao.insertQuestion(questionMoCo)
        }
    }

    val questionMathe = Question(
        1,
        "Mathe",
        "Wie lautet die erste binomische Formel?",
        listOf("(a-b)^2","(a+b)^2","(a+b)(a+b)"),
        1,
        false,
        50
    )

    val questionSoftwaretechnik = Question(
        2,
        "Softwaretechnik",
        "Wofür steht der Begriff MOOS?",
        listOf("Methodische Objekt-orientierte Softwareentwicklung","Mathematische Objekt-orientierte Softwareentwicklung","Methodische Objekt-orientierte Softwarespezifikation"),
        0,
        false,
        50
    )

    val questionMoCo = Question(
        3,
        "Mobile Computing",
        "Wofür steht der Begriff DAO?",
        listOf("Daten Aufrufoperationen","Decimal Access Orientiation","Data Access Object"),
        2,
        false,
        50
    )
}
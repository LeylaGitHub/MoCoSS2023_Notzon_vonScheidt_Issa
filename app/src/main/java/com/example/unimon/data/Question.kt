package com.example.unimon.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey var id: Int,
    var category: String,
    var question: String,
    var answer1: String,
    var answer2: String,
    var answer3: String,
    var correctAnswer: Int,
    var solved: Boolean,
    var experience: Int,
)

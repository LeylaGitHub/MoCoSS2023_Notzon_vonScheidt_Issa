package com.example.unimon.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey var category: String,
    @PrimaryKey var id: Int,
    var question: String,
    var answer1: String,
    var answer2: String,
    var answer3: String,
    var correctAnswer: String,
    var solved: Boolean,
    var experience: Int,
)

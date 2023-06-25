package com.example.unimon.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question")
    fun getQuestion(): Question

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewQuestion(data: Question)

    @Update
    fun updateQuestion(question: Question)
}
package com.example.unimon.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UnimonDao {
    @Query("SELECT * FROM unimon")
    fun getUnimon(): Unimon

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewUnimon(data: Unimon)

    @Update
    fun updateUnimon(unimon: Unimon)
}

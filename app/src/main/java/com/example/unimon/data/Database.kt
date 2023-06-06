package com.example.unimon.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Unimon::class], version = 1)
abstract class UnimonDatabase : RoomDatabase() {
    abstract fun unimonDao(): UnimonDao

    companion object {
        @Volatile
        private var INSTANCE: UnimonDatabase? = null

        fun getInstance(context: Context): UnimonDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UnimonDatabase::class.java,
                    "Unimon"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
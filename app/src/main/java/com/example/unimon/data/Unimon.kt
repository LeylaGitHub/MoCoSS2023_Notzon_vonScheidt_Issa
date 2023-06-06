package com.example.unimon.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Unimon(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    var name: String,
    var level: Int,
    var body: Int,
    var mind: Int,
    var social: Int,
    var sleep: Int
)
package com.example.musicquizapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "albums")
data class Album(
    @PrimaryKey val id: Long,
    val title: String,
    val cover: String
)

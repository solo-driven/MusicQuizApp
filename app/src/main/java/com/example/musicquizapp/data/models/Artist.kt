package com.example.musicquizapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artists")
data class Artist(
    @PrimaryKey val id: Long,
    val name: String,
    val picture: String
)

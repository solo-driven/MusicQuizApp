package com.example.musicquizapp.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "tracks",
    foreignKeys = [
        ForeignKey(entity = Artist::class, parentColumns = ["id"], childColumns = ["artistId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Album::class, parentColumns = ["id"], childColumns = ["albumId"], onDelete = ForeignKey.CASCADE)
    ]
    ,
    indices = [
        Index(value = ["artistId"]),
        Index(value = ["albumId"]),
        Index(value = ["title"]) // Optional: Index on title if you frequently search by title
    ]

)
data class Track(
    @PrimaryKey val id: Long,
    val title: String,
    val artistId: Long,
    val albumId: Long,
    val song: String // URL to the preview song
)

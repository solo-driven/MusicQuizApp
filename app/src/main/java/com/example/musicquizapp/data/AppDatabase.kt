package com.example.musicquizapp.data


import com.example.musicquizapp.data.dao.TrackDao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.musicquizapp.data.models.Album

import com.example.musicquizapp.data.models.Artist

import androidx.room.Room
import android.content.Context
import com.example.musicquizapp.data.dao.AlbumDao
import com.example.musicquizapp.data.dao.ArtistDao
import com.example.musicquizapp.data.models.Track

@Database(entities = [Artist::class, Album::class, Track::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun artistDao(): ArtistDao
    abstract fun albumDao(): AlbumDao
    abstract fun trackDao(): TrackDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "deezer_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}



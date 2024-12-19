package com.example.musicquizapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.musicquizapp.data.models.Track


@Dao
interface TrackDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTracks(tracks: List<Track>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrack(track: Track)

    @Query("SELECT * FROM tracks WHERE id = :id")
    fun getTrackById(id: Long): Track?

    @Query("SELECT * FROM tracks")
    fun getAllTracks(): List<Track>
}

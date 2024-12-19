package com.example.musicquizapp.data
import android.content.Context

import com.example.musicquizapp.data.models.Album
import com.example.musicquizapp.data.models.Artist
import com.example.musicquizapp.data.models.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.net.URL

class DeezerRepository(private val db: AppDatabase, private val context: Context) {

    private val artistDao = db.artistDao()
    private val albumDao = db.albumDao()
    private val trackDao = db.trackDao()

    // Insert data into the database
    suspend fun insertData(artists: List<Artist>, albums: List<Album>, tracks: List<Track>) {
        withContext(Dispatchers.IO) {
            artistDao.insertArtists(artists)
            albumDao.insertAlbums(albums)
            trackDao.insertTracks(tracks)
        }
    }

    // Fetch all tracks with related artist and album
    suspend fun getAllTracksWithDetails(): List<TrackWithDetails> {
        return withContext(Dispatchers.IO) {
            val tracks = trackDao.getAllTracks()
            tracks.map { track ->
                val artist = artistDao.getArtistById(track.artistId)
                val album = albumDao.getAlbumById(track.albumId)
                TrackWithDetails(track, artist, album)
            }
        }
    }

    // Caching Preview Song
    suspend fun getCachedSong(previewUrl: String): File? {
        return withContext(Dispatchers.IO) {
            val fileName = previewUrl.hashCode().toString()
            val file = File(context.cacheDir, "$fileName.mp3")
            if (file.exists()) {
                file
            } else {
                try {
                    URL(previewUrl).openStream().use { input ->
                        FileOutputStream(file).use { output ->
                            input.copyTo(output)
                        }
                    }
                    file
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }
            }
        }
    }
}

// Data class to hold Track with its Artist and Album details
data class TrackWithDetails(
    val track: Track,
    val artist: Artist?,
    val album: Album?
)

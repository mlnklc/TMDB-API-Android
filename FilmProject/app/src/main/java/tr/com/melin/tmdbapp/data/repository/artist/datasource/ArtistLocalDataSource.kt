package tr.com.melin.tmdbapp.data.repository.artist.datasource

import tr.com.melin.tmdbapp.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(artist: List<Artist>)
    suspend fun clearAll()
}
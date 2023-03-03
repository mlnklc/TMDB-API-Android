package tr.com.melin.tmdbapp.data.repository.artist.datasource

import tr.com.melin.tmdbapp.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun saveArtistsToCache(artists: List<Artist>)
    suspend fun getArtistsFromCache(): List<Artist>
}
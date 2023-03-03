package tr.com.melin.tmdbapp.domain.repository

import tr.com.melin.tmdbapp.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists() : List<Artist>?
}
package tr.com.melin.tmdbapp.data.repository.artist.datasource

import retrofit2.Response
import tr.com.melin.tmdbapp.data.model.artist.ArtistList
import tr.com.melin.tmdbapp.data.model.movie.MovieList

interface ArtistRemoteDataSource {
    suspend fun getArtists() : Response<ArtistList>
}
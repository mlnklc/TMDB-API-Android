package tr.com.melin.tmdbapp.data.repository.artist.datasourceImpl

import retrofit2.Response
import tr.com.melin.tmdbapp.data.api.TMDBService
import tr.com.melin.tmdbapp.data.model.artist.ArtistList
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey : String) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getArtists(apiKey)
}
package tr.com.melin.tmdbapp.data.repository.tvshow.datasourceImpl

import retrofit2.Response
import tr.com.melin.tmdbapp.data.api.TMDBService
import tr.com.melin.tmdbapp.data.model.tvshow.TVShowList
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowRemoteDataSource

class TVShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey : String) : TVShowRemoteDataSource {
    override suspend fun getTVShowsFromAPI(): Response<TVShowList> = tmdbService.getTVShows(apiKey)
}
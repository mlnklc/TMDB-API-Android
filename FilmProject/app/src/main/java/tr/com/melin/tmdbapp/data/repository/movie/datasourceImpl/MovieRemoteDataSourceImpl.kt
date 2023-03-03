package tr.com.melin.tmdbapp.data.repository.movie.datasourceImpl

import retrofit2.Response
import tr.com.melin.tmdbapp.data.api.TMDBService
import tr.com.melin.tmdbapp.data.model.movie.MovieList
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}
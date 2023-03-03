package tr.com.melin.tmdbapp.data.repository.movie.datasource

import retrofit2.Response
import tr.com.melin.tmdbapp.data.model.movie.MovieList

/**
 * This interface will be using for getting movies from API
 */
interface MovieRemoteDataSource {
    suspend fun getMovies() : Response<MovieList>
}
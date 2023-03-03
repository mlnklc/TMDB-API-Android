package tr.com.melin.tmdbapp.data.repository.movie.datasource

import tr.com.melin.tmdbapp.data.model.movie.Movie

/**
 * This interface will be using for getting the already loaded movies from cache
 * instead of calling database or network functions
 */
interface MovieCacheDataSource {
    suspend fun saveMoviesToCache(movies : List<Movie>)
    suspend fun getMoviesFromCache():List<Movie>
}
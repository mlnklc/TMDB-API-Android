package tr.com.melin.tmdbapp.data.repository.movie.datasource

import tr.com.melin.tmdbapp.data.model.movie.Movie

/**
 * This interface will be using for getting movies from local database(Room)
 */
interface MovieLocalDataSource {
    suspend fun getMovieFromDatabase() : List<Movie>
    suspend fun saveMoviesToDB(movies : List<Movie>)
    suspend fun clearAll()
}
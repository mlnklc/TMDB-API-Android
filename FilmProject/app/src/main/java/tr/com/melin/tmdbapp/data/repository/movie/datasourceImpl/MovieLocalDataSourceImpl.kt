package tr.com.melin.tmdbapp.data.repository.movie.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tr.com.melin.tmdbapp.data.db.MovieDao
import tr.com.melin.tmdbapp.data.model.movie.Movie
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource

class MovieLocalDataSourceImpl (private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMovieFromDatabase(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }

}
package tr.com.melin.tmdbapp.data.repository.movie

import android.util.Log
import tr.com.melin.tmdbapp.data.model.movie.Movie
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import tr.com.melin.tmdbapp.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    private val TAG: String = this::class.simpleName.toString()

    /**
     * This function returns a list of movie instances
     */
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    /**
     * This method updates the database with the latest popular movies, taken from the TMDB Api.
     * @return - new list of the latest movie instance
     */
    override suspend fun updateMovies(): List<Movie>? {
        val latestMoviesList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(latestMoviesList)
        movieCacheDataSource.saveMoviesToCache(latestMoviesList)
        return latestMoviesList
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                Log.d("MYTAG", body.toString())
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.d(TAG, exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMovieFromDatabase()
        } catch (exception: Exception) {
            Log.d(TAG, exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.d(TAG, exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}
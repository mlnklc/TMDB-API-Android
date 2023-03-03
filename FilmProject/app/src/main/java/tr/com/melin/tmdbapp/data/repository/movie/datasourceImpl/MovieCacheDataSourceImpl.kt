package tr.com.melin.tmdbapp.data.repository.movie.datasourceImpl

import tr.com.melin.tmdbapp.data.api.TMDBService
import tr.com.melin.tmdbapp.data.model.movie.Movie
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }
}
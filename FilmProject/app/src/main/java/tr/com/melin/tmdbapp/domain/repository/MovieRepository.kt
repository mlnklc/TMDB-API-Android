package tr.com.melin.tmdbapp.domain.repository

import tr.com.melin.tmdbapp.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}
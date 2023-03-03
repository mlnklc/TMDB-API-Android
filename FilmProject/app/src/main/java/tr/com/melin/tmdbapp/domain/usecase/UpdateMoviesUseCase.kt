package tr.com.melin.tmdbapp.domain.usecase

import tr.com.melin.tmdbapp.data.model.movie.Movie
import tr.com.melin.tmdbapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() : List<Movie> ? = movieRepository.updateMovies()
}
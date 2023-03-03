package tr.com.melin.tmdbapp.domain.usecase

import tr.com.melin.tmdbapp.data.model.movie.Movie
import tr.com.melin.tmdbapp.domain.repository.MovieRepository

class GetMoviesUseCase (private val movieRepo:MovieRepository){
     suspend fun execute() : List<Movie> ? = movieRepo.getMovies()
}
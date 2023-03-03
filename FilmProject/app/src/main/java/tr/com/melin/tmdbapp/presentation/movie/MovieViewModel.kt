package tr.com.melin.tmdbapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import tr.com.melin.tmdbapp.domain.usecase.GetMoviesUseCase
import tr.com.melin.tmdbapp.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovie() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}
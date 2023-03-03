package tr.com.melin.tmdbapp.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import tr.com.melin.tmdbapp.domain.usecase.GetTVShowsUseCase
import tr.com.melin.tmdbapp.domain.usecase.UpdateTVShowsUseCase

class TVShowsViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModel(){

    fun getTVShows() = liveData {
        val tvShowsList = getTVShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTVShows() = liveData {
        val tvShowsList = updateTVShowsUseCase.execute()
        emit(tvShowsList)
    }
}
package tr.com.melin.tmdbapp.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tr.com.melin.tmdbapp.domain.usecase.GetTVShowsUseCase
import tr.com.melin.tmdbapp.domain.usecase.UpdateTVShowsUseCase

class TVShowViewModelFactory(
    private val getTvShowsUseCase: GetTVShowsUseCase,
    private val updateTvShowsUseCase: UpdateTVShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowsViewModel(
            getTvShowsUseCase,
            updateTvShowsUseCase
        ) as T
    }
}
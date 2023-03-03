package tr.com.melin.tmdbapp.presentation.di.tvshow

import dagger.Module
import dagger.Provides
import tr.com.melin.tmdbapp.domain.usecase.GetTVShowsUseCase
import tr.com.melin.tmdbapp.domain.usecase.UpdateTVShowsUseCase
import tr.com.melin.tmdbapp.presentation.tv.TVShowViewModelFactory

@Module
class TvShowModule {
    @TVShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTVShowsUseCase,
        updateTvShowsUseCase: UpdateTVShowsUseCase
    ): TVShowViewModelFactory {
        return TVShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}
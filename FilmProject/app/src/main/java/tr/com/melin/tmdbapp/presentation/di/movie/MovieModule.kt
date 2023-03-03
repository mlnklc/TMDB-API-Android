package tr.com.melin.tmdbapp.presentation.di.movie

import dagger.Module
import dagger.Provides
import tr.com.melin.tmdbapp.domain.usecase.GetMoviesUseCase
import tr.com.melin.tmdbapp.domain.usecase.UpdateMoviesUseCase
import tr.com.melin.tmdbapp.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}
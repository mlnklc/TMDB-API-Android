package tr.com.melin.tmdbapp.presentation.di.core

import androidx.room.Update
import dagger.Module
import dagger.Provides
import tr.com.melin.tmdbapp.domain.repository.ArtistsRepository
import tr.com.melin.tmdbapp.domain.repository.MovieRepository
import tr.com.melin.tmdbapp.domain.repository.TVShowsRepository
import tr.com.melin.tmdbapp.domain.usecase.*

@Module
class UseCaseModule {
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TVShowsRepository):GetTVShowsUseCase{
        return GetTVShowsUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TVShowsRepository):UpdateTVShowsUseCase{
        return UpdateTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistsRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistsRepository):UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }
}
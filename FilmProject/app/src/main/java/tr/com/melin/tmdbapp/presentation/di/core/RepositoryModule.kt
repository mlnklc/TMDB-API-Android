package tr.com.melin.tmdbapp.presentation.di.core

import dagger.Module
import dagger.Provides
import tr.com.melin.tmdbapp.data.repository.artist.ArtistRepositoryImpl
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import tr.com.melin.tmdbapp.data.repository.movie.MovieRepositoryImpl
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import tr.com.melin.tmdbapp.data.repository.tvshow.TVShowRepositoryImpl
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowCacheDataSource
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowLocalDataSource
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowRemoteDataSource
import tr.com.melin.tmdbapp.domain.repository.ArtistsRepository
import tr.com.melin.tmdbapp.domain.repository.MovieRepository
import tr.com.melin.tmdbapp.domain.repository.TVShowsRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTVShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ): TVShowsRepository {
        return TVShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistsRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}
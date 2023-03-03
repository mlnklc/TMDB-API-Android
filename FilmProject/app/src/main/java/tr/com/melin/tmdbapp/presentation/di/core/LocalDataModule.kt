package tr.com.melin.tmdbapp.presentation.di.core

import dagger.Module
import dagger.Provides
import tr.com.melin.tmdbapp.data.db.ArtistDao
import tr.com.melin.tmdbapp.data.db.MovieDao
import tr.com.melin.tmdbapp.data.db.TVShowDao
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import tr.com.melin.tmdbapp.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import tr.com.melin.tmdbapp.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowLocalDataSource
import tr.com.melin.tmdbapp.data.repository.tvshow.datasourceImpl.TVShowLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvShowDao: TVShowDao) : TVShowLocalDataSource {
        return TVShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}
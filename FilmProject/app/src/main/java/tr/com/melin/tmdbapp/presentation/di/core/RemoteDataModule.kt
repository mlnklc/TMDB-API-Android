package tr.com.melin.tmdbapp.presentation.di.core

import dagger.Module
import dagger.Provides
import tr.com.melin.tmdbapp.data.api.TMDBService
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import tr.com.melin.tmdbapp.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import tr.com.melin.tmdbapp.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowRemoteDataSource
import tr.com.melin.tmdbapp.data.repository.tvshow.datasourceImpl.TVShowRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTVShowRemoteDataSource(tmdbService: TMDBService) : TVShowRemoteDataSource{
        return TVShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}
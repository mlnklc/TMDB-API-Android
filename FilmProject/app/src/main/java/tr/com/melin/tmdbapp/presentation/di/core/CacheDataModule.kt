package tr.com.melin.tmdbapp.presentation.di.core

import dagger.Module
import dagger.Provides
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import tr.com.melin.tmdbapp.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import tr.com.melin.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import tr.com.melin.tmdbapp.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowCacheDataSource
import tr.com.melin.tmdbapp.data.repository.tvshow.datasourceImpl.TVShowCacheDataSourceImpl
import javax.inject.Singleton
@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowCacheDataSource(): TVShowCacheDataSource{
        return TVShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

}
package tr.com.melin.tmdbapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import tr.com.melin.tmdbapp.data.db.ArtistDao
import tr.com.melin.tmdbapp.data.db.MovieDao
import tr.com.melin.tmdbapp.data.db.TMDBDatabase
import tr.com.melin.tmdbapp.data.db.TVShowDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideTMDBDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTVShowDao(tmdbDatabase: TMDBDatabase): TVShowDao {
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtist(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }

}
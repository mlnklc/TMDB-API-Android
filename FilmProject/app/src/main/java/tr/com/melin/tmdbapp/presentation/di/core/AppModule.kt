package tr.com.melin.tmdbapp.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import tr.com.melin.tmdbapp.presentation.di.artist.ArtistSubComponent
import tr.com.melin.tmdbapp.presentation.di.movie.MovieSubComponent
import tr.com.melin.tmdbapp.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}
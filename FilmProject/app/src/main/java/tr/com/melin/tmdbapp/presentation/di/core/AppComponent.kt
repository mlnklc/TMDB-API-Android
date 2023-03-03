package tr.com.melin.tmdbapp.presentation.di.core

import dagger.Component
import tr.com.melin.tmdbapp.presentation.di.artist.ArtistSubComponent
import tr.com.melin.tmdbapp.presentation.di.movie.MovieSubComponent
import tr.com.melin.tmdbapp.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory

}
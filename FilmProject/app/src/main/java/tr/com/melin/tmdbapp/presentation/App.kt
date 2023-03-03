package tr.com.melin.tmdbapp.presentation

import android.app.Application
import tr.com.melin.tmdbapp.BuildConfig
import tr.com.melin.tmdbapp.presentation.di.Injector
import tr.com.melin.tmdbapp.presentation.di.artist.ArtistSubComponent
import tr.com.melin.tmdbapp.presentation.di.core.*
import tr.com.melin.tmdbapp.presentation.di.movie.MovieSubComponent
import tr.com.melin.tmdbapp.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.themoviedb.org"))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}
package tr.com.melin.tmdbapp.presentation.di.movie

import dagger.Subcomponent
import tr.com.melin.tmdbapp.presentation.movie.MovieActivity

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }

}
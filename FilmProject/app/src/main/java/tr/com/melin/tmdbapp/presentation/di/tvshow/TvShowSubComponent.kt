package tr.com.melin.tmdbapp.presentation.di.tvshow

import dagger.Subcomponent
import tr.com.melin.tmdbapp.presentation.tv.TVShowActivity

@TVShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }

}
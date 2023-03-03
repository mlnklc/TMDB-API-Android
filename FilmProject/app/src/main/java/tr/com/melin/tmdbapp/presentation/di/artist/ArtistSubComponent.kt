package tr.com.melin.tmdbapp.presentation.di.artist

import dagger.Subcomponent
import tr.com.melin.tmdbapp.presentation.artist.ArtistActivity

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }

}
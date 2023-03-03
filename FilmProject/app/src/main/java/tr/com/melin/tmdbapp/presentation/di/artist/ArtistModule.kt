package tr.com.melin.tmdbapp.presentation.di.artist

import dagger.Module
import dagger.Provides
import tr.com.melin.tmdbapp.domain.usecase.GetArtistsUseCase
import tr.com.melin.tmdbapp.domain.usecase.UpdateArtistsUseCase
import tr.com.melin.tmdbapp.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}
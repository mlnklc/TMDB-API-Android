package tr.com.melin.tmdbapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import tr.com.melin.tmdbapp.domain.usecase.GetArtistsUseCase
import tr.com.melin.tmdbapp.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}
package tr.com.melin.tmdbapp.domain.usecase

import tr.com.melin.tmdbapp.data.model.artist.Artist
import tr.com.melin.tmdbapp.domain.repository.ArtistsRepository

class GetArtistsUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute() : List<Artist>? = artistsRepository.getArtists()
}
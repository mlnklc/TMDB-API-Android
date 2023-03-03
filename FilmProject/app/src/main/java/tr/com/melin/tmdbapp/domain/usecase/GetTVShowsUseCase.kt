package tr.com.melin.tmdbapp.domain.usecase

import tr.com.melin.tmdbapp.data.model.tvshow.TVShow
import tr.com.melin.tmdbapp.domain.repository.TVShowsRepository

class GetTVShowsUseCase(private val tvShowsRepository: TVShowsRepository) {
    suspend fun execute() : List<TVShow>? = tvShowsRepository.getTVShows()
}
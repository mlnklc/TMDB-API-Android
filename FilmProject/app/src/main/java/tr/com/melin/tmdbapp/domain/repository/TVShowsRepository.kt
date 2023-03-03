package tr.com.melin.tmdbapp.domain.repository

import tr.com.melin.tmdbapp.data.model.tvshow.TVShow

interface TVShowsRepository {
    suspend fun getTVShows() : List<TVShow>?
    suspend fun updateTVShows() : List<TVShow>?
}
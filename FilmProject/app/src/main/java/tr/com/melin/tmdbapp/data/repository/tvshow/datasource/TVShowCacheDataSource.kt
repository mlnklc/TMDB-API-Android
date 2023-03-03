package tr.com.melin.tmdbapp.data.repository.tvshow.datasource

import tr.com.melin.tmdbapp.data.model.movie.Movie
import tr.com.melin.tmdbapp.data.model.tvshow.TVShow

interface TVShowCacheDataSource {
    suspend fun saveTVShowsToCache(tvShows : List<TVShow>)
    suspend fun getTVShowsFromCache() : List<TVShow>
}
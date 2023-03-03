package tr.com.melin.tmdbapp.data.repository.tvshow.datasource

import tr.com.melin.tmdbapp.data.model.movie.Movie
import tr.com.melin.tmdbapp.data.model.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShowsFromDB() : List<TVShow>
    suspend fun saveTVShowsToDB(tvShows: List<TVShow>)
    suspend fun clearAll()
}
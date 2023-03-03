package tr.com.melin.tmdbapp.data.repository.tvshow.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tr.com.melin.tmdbapp.data.db.TVShowDao
import tr.com.melin.tmdbapp.data.model.tvshow.TVShow
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowLocalDataSource

class TVShowLocalDataSourceImpl(private val tvShowDao: TVShowDao) : TVShowLocalDataSource {
    override suspend fun getTVShowsFromDB(): List<TVShow> = tvShowDao.getTvShows()

    override suspend fun saveTVShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}
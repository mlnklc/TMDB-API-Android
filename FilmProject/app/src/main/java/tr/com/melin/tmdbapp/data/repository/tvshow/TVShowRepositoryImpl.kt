package tr.com.melin.tmdbapp.data.repository.tvshow

import android.util.Log
import tr.com.melin.tmdbapp.data.model.tvshow.TVShow
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowCacheDataSource
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowLocalDataSource
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowRemoteDataSource
import tr.com.melin.tmdbapp.domain.repository.TVShowsRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource
) : TVShowsRepository {

    private val TAG: String = this::class.simpleName.toString()

    override suspend fun getTVShows(): List<TVShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        var theLatestTVShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowsToDB(theLatestTVShows)
        tvShowCacheDataSource.saveTVShowsToCache(theLatestTVShows)
        return theLatestTVShows
    }

    suspend fun getTvShowsFromAPI(): List<TVShow> {
        lateinit var tvShowsList: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTVShowsFromAPI()
            val body = response.body()
            if (body != null) {
                tvShowsList = body.results
            }
        } catch (exception: Exception) {
            Log.d(TAG, exception.message.toString())
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromDB(): List<TVShow> {
        lateinit var tvShowsList: List<TVShow>
        try {
            tvShowsList = tvShowLocalDataSource.getTVShowsFromDB()
        } catch (exception: Exception) {
            Log.d(TAG, exception.message.toString())
        }
        if (tvShowsList.isNotEmpty()) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTVShowsToDB(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TVShow> {
        lateinit var tvShowsList: List<TVShow>
        try {
            tvShowsList = tvShowCacheDataSource.getTVShowsFromCache()
        } catch (exception: Exception) {
            Log.d(TAG, exception.message.toString())
        }
        if (tvShowsList.isNotEmpty()) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTVShowsToCache(tvShowsList)
        }
        return tvShowsList
    }
}

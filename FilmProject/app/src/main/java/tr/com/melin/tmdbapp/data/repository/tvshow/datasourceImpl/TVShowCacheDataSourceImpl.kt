package tr.com.melin.tmdbapp.data.repository.tvshow.datasourceImpl

import tr.com.melin.tmdbapp.data.model.tvshow.TVShow
import tr.com.melin.tmdbapp.data.repository.tvshow.datasource.TVShowCacheDataSource

class TVShowCacheDataSourceImpl : TVShowCacheDataSource{
    private var tvShowList = ArrayList<TVShow>()
    override suspend fun saveTVShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }

    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return tvShowList
    }

}
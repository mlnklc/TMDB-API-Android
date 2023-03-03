package tr.com.melin.tmdbapp.data.repository.tvshow.datasource

import retrofit2.Response
import tr.com.melin.tmdbapp.data.model.tvshow.TVShowList

interface TVShowRemoteDataSource {
    suspend fun getTVShowsFromAPI() : Response<TVShowList>
}
package tr.com.melin.tmdbapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import tr.com.melin.tmdbapp.data.model.artist.ArtistList
import tr.com.melin.tmdbapp.data.model.movie.MovieList
import tr.com.melin.tmdbapp.data.model.tvshow.TVShowList

interface TMDBService {

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(@Query ("api_key") apiKey:String) : Response<MovieList>

    @GET("/3/tv/popular")
    suspend fun getTVShows(@Query ("api_key") apiKey: String) : Response<TVShowList>

    @GET("/3/person/popular")
    suspend fun getArtists(@Query("api_key") apiKey: String) : Response<ArtistList>
}
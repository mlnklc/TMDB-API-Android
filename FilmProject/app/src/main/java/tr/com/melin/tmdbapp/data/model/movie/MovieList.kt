package tr.com.melin.tmdbapp.data.model.movie


import com.google.gson.annotations.SerializedName
import tr.com.melin.tmdbapp.data.model.movie.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)
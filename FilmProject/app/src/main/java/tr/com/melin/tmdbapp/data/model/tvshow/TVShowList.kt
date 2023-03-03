package tr.com.melin.tmdbapp.data.model.tvshow


import com.google.gson.annotations.SerializedName
import tr.com.melin.tmdbapp.data.model.tvshow.TVShow

data class TVShowList(
    @SerializedName("results")
    val results: List<TVShow>
)
package tr.com.melin.tmdbapp.data.model.artist


import com.google.gson.annotations.SerializedName
import tr.com.melin.tmdbapp.data.model.artist.Artist

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>,
)
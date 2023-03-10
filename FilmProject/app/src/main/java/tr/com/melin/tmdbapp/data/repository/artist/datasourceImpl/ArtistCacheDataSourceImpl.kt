package tr.com.melin.tmdbapp.data.repository.artist.datasourceImpl

import tr.com.melin.tmdbapp.data.model.artist.Artist
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }
}
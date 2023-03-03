package tr.com.melin.tmdbapp.data.repository.artist

import android.util.Log
import tr.com.melin.tmdbapp.data.model.artist.Artist
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import tr.com.melin.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import tr.com.melin.tmdbapp.domain.repository.ArtistsRepository
import java.lang.Exception

class ArtistRepositoryImpl(private val artistRemoteDatasource: ArtistRemoteDataSource,
                           private val artistLocalDataSource: ArtistLocalDataSource,
                           private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistsRepository{

    private val TAG : String = this::class.simpleName.toString()

    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val latestArtistList = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(latestArtistList)
        artistCacheDataSource.saveArtistsToCache(latestArtistList)
        return latestArtistList
    }

    suspend fun getArtistFromAPI() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        }catch (exception : Exception){
            Log.d(TAG,exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (exception : Exception){
            Log.d(TAG,exception.message.toString())
        }

        if (artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (exception : Exception){
            Log.d(TAG,exception.message.toString())
        }
        if(artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}
package tr.com.melin.tmdbapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import tr.com.melin.tmdbapp.data.model.artist.Artist
import tr.com.melin.tmdbapp.data.model.movie.Movie
import tr.com.melin.tmdbapp.data.model.tvshow.TVShow

@Database(entities = [Movie::class,Artist::class,TVShow::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){
    abstract fun movieDao() : MovieDao
    abstract fun artistDao() : ArtistDao
    abstract fun tvShowDao() : TVShowDao
}
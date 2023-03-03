package tr.com.melin.tmdbapp.presentation.di

import tr.com.melin.tmdbapp.presentation.di.artist.ArtistSubComponent
import tr.com.melin.tmdbapp.presentation.di.movie.MovieSubComponent
import tr.com.melin.tmdbapp.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}
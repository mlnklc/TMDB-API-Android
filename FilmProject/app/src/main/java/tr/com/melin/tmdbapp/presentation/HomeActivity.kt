package tr.com.melin.tmdbapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import tr.com.melin.tmdbapp.R
import tr.com.melin.tmdbapp.databinding.ActivityHomeBinding
import tr.com.melin.tmdbapp.presentation.artist.ArtistActivity
import tr.com.melin.tmdbapp.presentation.movie.MovieActivity
import tr.com.melin.tmdbapp.presentation.tv.TVShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.movieButton.setOnClickListener {
            val intent = Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }
        binding.artistsButton.setOnClickListener {
            val intent = Intent(this,ArtistActivity::class.java)
            startActivity(intent)
        }
        binding.tvButton.setOnClickListener {
            val intent = Intent(this,TVShowActivity::class.java)
            startActivity(intent)
        }
    }
}
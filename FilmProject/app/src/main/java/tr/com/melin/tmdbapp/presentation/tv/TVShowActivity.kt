package tr.com.melin.tmdbapp.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import tr.com.melin.tmdbapp.R
import tr.com.melin.tmdbapp.databinding.ActivityHomeBinding
import tr.com.melin.tmdbapp.databinding.ActivityTvshowBinding
import tr.com.melin.tmdbapp.presentation.di.Injector
import javax.inject.Inject

class TVShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TVShowViewModelFactory
    private lateinit var tvShowViewModel: TVShowsViewModel
    private lateinit var adapter: TVShowAdapter
    private lateinit var binding: ActivityTvshowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tvshow)
        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel= ViewModelProvider(this,factory)
            .get(TVShowsViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TVShowAdapter()
        binding.tvRecyclerView.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows(){
        binding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTVShows()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            }else{
                binding.tvProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateTvShows(){
        binding.tvProgressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTVShows()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            }else{
                binding.tvProgressBar.visibility = View.GONE
            }
        })
    }
}
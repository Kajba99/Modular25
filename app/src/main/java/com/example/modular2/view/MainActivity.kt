package com.example.modular2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.modular2.helper.Resource
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modular2.R
import com.example.modular2.adapter.ArticleAdapter
import com.example.modular2.databinding.ActivityMainBinding
import com.example.modular2.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    public val viewModel: MoviesViewModel by viewModels()
    private lateinit var MoviesAdapter : ArticleAdapter
    private lateinit var myToolbar : Toolbar
    private lateinit var prog : ProgressBar
    private lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()

        prog = findViewById(R.id.progress_bar)
        text = findViewById(R.id.text_view_error)


    }

    private fun setUp() {
        MoviesAdapter = ArticleAdapter()
        binding.rvMoviesList.apply {
            adapter = MoviesAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.VERTICAL, false
            )
            setHasFixedSize(true)
        }
        viewModel.article.observe(this, { result ->
            MoviesAdapter.movies = result.data!!

            prog.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
            text.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
            text.text = result.error?.localizedMessage

        })
    }
}
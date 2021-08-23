package com.example.modular2.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.modular2.databinding.MoviesLayoutAdapterBinding
import com.example.modular2.data.Article
import com.example.modular2.view.DetailedActivity

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.MyViewHolder>() {

    private lateinit var context: Context


    inner class MyViewHolder(val binding: MoviesLayoutAdapterBinding) :
            RecyclerView.ViewHolder(binding.root)



    private val diffCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var movies : List<Article>
    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        return MyViewHolder(MoviesLayoutAdapterBinding.inflate(
            LayoutInflater.from(context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentMovie = movies[position]

        holder.binding.apply {

            movieTitle.text = currentMovie.title

            moviePoster.load(currentMovie.urlToImage){
                crossfade(true)
                crossfade(1000)
            }
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailedActivity::class.java)

            val bundle = Bundle()
            bundle.putString("description", movies[position].description)
            bundle.putString("title", movies[position].title)
            bundle.putString("image", movies[position].urlToImage)
            bundle.putString("url", movies[position].url)

            intent.putExtras(bundle)
            context.startActivity(intent)
        }

    }

    override fun getItemCount() = movies.size

}
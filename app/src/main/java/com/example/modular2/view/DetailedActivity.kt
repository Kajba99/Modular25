package com.example.modular2.view

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import coil.load
import com.bumptech.glide.Glide
import com.example.modular2.R
import com.example.modular2.data.Article
import com.example.modular2.databinding.ActivityDetailedBinding
import org.w3c.dom.Text

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding
    private lateinit var article: Article


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
// prvi
        var web: WebView = findViewById(R.id.webview)
        var name: TextView = findViewById(R.id.tvdetailed)
        var image : ImageView = findViewById(R.id.ivdetailed)
        var myToolbar: Toolbar = findViewById(R.id.myToolbar)
// drugi
        var bundle: Bundle? = intent.extras
// treci
        val ime = bundle!!.getString("title")
        val slika = bundle.getString("image")
        val url = bundle.getString("url")
// cetvrti
        name.text = ime
        Glide.with(this).load(slika).into(image)
        web.settings.javaScriptEnabled = true
        web.webViewClient = WebViewClient()
        web.loadUrl(url.toString())


        myToolbar.title = ime
        setSupportActionBar(myToolbar)

        myToolbar.setNavigationOnClickListener {
            startActivity(Intent(this@DetailedActivity, MainActivity::class.java ))
        }


        //setUp()
    }

/*
    private fun setUp() {
        binding.apply {
            tvdetailed.text = article.description
            ivdetailed.load(article.urlToImage) {
                crossfade(true)
                crossfade(1000)
            }

        }
    }
    */

}
package com.febryan.idnnews

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.febryan.idnnews.databinding.ActivityDetailNewsBinding
import com.febryan.idnnews.model.DataArtikelItem
import kotlinx.android.synthetic.main.activity_detail_news.*
import kotlinx.android.synthetic.main.content_scrolling.view.*

class DetailNewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(findViewById(R.id.toolbar))


        val dataNews = intent.getParcelableExtra<DataArtikelItem>("DTL")
        if (dataNews != null){

            content_news.tv_detail_news.text = dataNews.isi

            Glide.with(this)
                .load(dataNews.gambar)
                .error(R.drawable.ic_launcher_background)
                .into(img_detail_news)

//            toolbar_layout_judul.title = dataNews.judul
            binding.toolbarLayoutJudul.title = dataNews.judul
        }

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
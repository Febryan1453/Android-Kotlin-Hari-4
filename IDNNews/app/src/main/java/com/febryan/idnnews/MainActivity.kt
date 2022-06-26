package com.febryan.idnnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.febryan.idnnews.adapter.NewsAdapter
import com.febryan.idnnews.api.ApiConfig
import com.febryan.idnnews.model.ResponseNewsIdn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()

    }

    private fun getNews() {

//        ApiConfig.getService().getNewsIdn().enqueue(object : Callback<ResponseNewsIdn>{
//
//            override fun onResponse(call: Call<ResponseNewsIdn>,response: Response<ResponseNewsIdn>) {
//                if (response.isSuccessful){
//                    val responseNewsIdn = response.body()
//                    val msg = responseNewsIdn?.message
//                    Log.d("Cek", msg ?: "")
//                    Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseNewsIdn>, t: Throwable) {
//                Log.d("Cek", "Error"+t.localizedMessage)
//                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
//            }
//
//        })

        val rvNews = findViewById<RecyclerView>(R.id.rv_news)
        ApiConfig.getService().getNewsIdn().enqueue(object : Callback<ResponseNewsIdn>{

            override fun onResponse(call: Call<ResponseNewsIdn>,response: Response<ResponseNewsIdn>) {
                if (response.isSuccessful){
                    val responseNewsIdn = response.body()
                    val datNewsIdn = responseNewsIdn?.dataArtikel
                    val newsAdapter = NewsAdapter(datNewsIdn)

                    val msg = responseNewsIdn?.message
                    Log.d("Cek", msg ?: "")

                    rvNews.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        newsAdapter.notifyDataSetChanged()
                        adapter = newsAdapter
                    }

                }
            }

            override fun onFailure(call: Call<ResponseNewsIdn>, t: Throwable) {
                Log.d("Cek", "Error"+t.localizedMessage)
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

    }
}
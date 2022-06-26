package com.febryan.idnnews.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.febryan.idnnews.DetailNewsActivity
import com.febryan.idnnews.R
import com.febryan.idnnews.model.DataArtikelItem

class NewsAdapter(val dataNews: List<DataArtikelItem?>?) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imgNews       = view.findViewById<ImageView>(R.id.item_img_news)
        val tvJudulNews   = view.findViewById<TextView>(R.id.item_tv_judul)
        val tvPenulisNews = view.findViewById<TextView>(R.id.item_tv_penulis)
        val tvTanggalNews = view.findViewById<TextView>(R.id.item_tv_tanggal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_row_news, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvJudulNews.text    = dataNews?.get(position)?.judul
        holder.tvPenulisNews.text  = dataNews?.get(position)?.author
        holder.tvTanggalNews.text  = dataNews?.get(position)?.tglPosting

        Glide.with(holder.itemView)
            .load(dataNews?.get(position)?.gambar)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgNews)

        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val i = Intent(context, DetailNewsActivity::class.java)
            i.putExtra("DTL", dataNews?.get(position))
            context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        if (dataNews != null){
            return dataNews.size
        }
        return 0
    }

}
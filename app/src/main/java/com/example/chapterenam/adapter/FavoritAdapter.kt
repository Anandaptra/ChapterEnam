package com.example.chapterenam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chapterenam.databinding.ItemFavoritBinding
import com.example.chapterenam.databinding.ItemMovieBinding
import com.example.chapterenam.model.Result
import com.example.chapterenam.room.FavNote

class FavoritAdapter(var listFav : List<FavNote>): RecyclerView.Adapter<FavoritAdapter.ViewHolder>() {

    class ViewHolder ( val binding:ItemFavoritBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemFavoritBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritAdapter.ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listFav[position]
        holder.binding.etJudul.text = list.title
        holder.binding.etTanggal.text = list.tanggal

        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w200/${list.poster_path}").fitCenter().into(holder.binding.imgMovie)
    }

    override fun getItemCount(): Int {
        return listFav.size
    }
}
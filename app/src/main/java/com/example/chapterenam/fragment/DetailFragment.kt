package com.example.chapterenam.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.chapterenam.R
import com.example.chapterenam.adapter.MovieAdapter
import com.example.chapterenam.databinding.FragmentDetailBinding
import com.example.chapterenam.model.Movie
import com.example.chapterenam.room.FavNote
import com.example.chapterenam.viewmodel.FavoritViewModel
import com.example.chapterenam.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    lateinit var filmViewModel: MovieViewModel
    lateinit var favoritViewModel: FavoritViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritViewModel = ViewModelProvider(this).get(FavoritViewModel::class.java)

        // pengambilan data
        val list = arguments?.getParcelable<Movie>("data_movie") as Movie
        val title = list.title
        val date = list.releaseDate
        val overview = list.overview
        val imagepath = list.imagePath


        binding.tvTitle.text = title
        binding.tvTglRelease.text = date
        binding.tvDesc.text = overview

        Glide.with(view.context).load("https://image.tmdb.org/t/p/w780${imagepath}").into(binding.imgMovie)

        binding.imgFav.setOnClickListener {
            favoritViewModel.insertMovie(title, id, date, imagepath)
            Toast.makeText(context, "Berhasil di tambah", Toast.LENGTH_SHORT).show()
        }

    }




}
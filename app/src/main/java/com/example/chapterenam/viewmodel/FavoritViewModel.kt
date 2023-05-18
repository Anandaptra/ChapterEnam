package com.example.chapterenam.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chapterenam.room.FavDao
import com.example.chapterenam.room.FavNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritViewModel @Inject constructor(private val favoriteDAO: FavDao): ViewModel( ){

    //insert favorite movie
    suspend fun insertFavoriteMovie( favorite: FavNote) = favoriteDAO.insertNote(favorite)

    fun insertMovie(title:String,id:Int,posterPath:String,releaseDate:String){
        viewModelScope.launch {
            val movie = FavNote(id,title,posterPath,releaseDate)
            favoriteDAO.insertNote(movie)
        }
    }
}
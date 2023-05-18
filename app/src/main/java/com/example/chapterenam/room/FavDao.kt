package com.example.chapterenam.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavDao {
    @Insert
    fun insertNote(note: FavNote)

    @Query("SELECT * FROM FavNote ORDER BY id ASC ")
    fun getDataNote() : List<FavNote>
}
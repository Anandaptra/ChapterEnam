package com.example.chapterenam.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [FavNote::class],
    version = 1
)

abstract class FavDatabase : RoomDatabase() {

    abstract fun favoritDao() : FavDao

}
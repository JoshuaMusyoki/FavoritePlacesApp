package com.nerds.favouriteplaces

import android.app.Application
import androidx.room.Room
import com.nerds.favouriteplaces.data.local.PlaceDatabase
import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp
class FavoritePlaceApp: Application() {
    val database = Room.databaseBuilder(
        applicationContext,
        PlaceDatabase::class.java, "place-db"
    ).build()

}
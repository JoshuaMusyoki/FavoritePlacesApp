package com.nerds.favouriteplaces.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places")
data class PlaceEntity (
    @PrimaryKey val id: String,
    val name: String,
    val location: String,
    val imageUrl: String,
    val isFavorite: Boolean = false
)

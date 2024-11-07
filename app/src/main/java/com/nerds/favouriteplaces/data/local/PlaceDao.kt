package com.nerds.favouriteplaces.data.local

import androidx.room.*

@Dao
interface PlaceDao {
    @Query("SELECT * FROM places")
    suspend fun getAllPlaces(): List<PlaceEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlace(place: PlaceEntity)

    @Delete
    suspend fun deletePlace(place: PlaceEntity)

    @Query("SELECT * FROM places WHERE isFavorite = 1")
    suspend fun getFavoritePlaces(): List<PlaceEntity>

    @Update
    suspend fun updatePlace(place: PlaceEntity)
}
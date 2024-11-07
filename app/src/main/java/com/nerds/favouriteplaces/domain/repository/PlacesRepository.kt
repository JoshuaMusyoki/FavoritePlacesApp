package com.nerds.favouriteplaces.domain.repository

import com.nerds.favouriteplaces.data.local.PlaceEntity
import com.nerds.favouriteplaces.domain.model.Places
import kotlinx.coroutines.flow.Flow

interface PlacesRepository {
    suspend fun getPlaces(): List<Places>
    suspend fun getFavouritePlaces(): List<Places>
    suspend fun markAsFavourite(places: Places)
    suspend fun removeFavourite(places: Places)

    suspend fun getDbPlaces(): List<PlaceEntity>
    suspend fun getDbFavorites(): List<PlaceEntity>
    suspend fun markAsDbFavourite(places: PlaceEntity)
    suspend fun removeDbFavourite(places: PlaceEntity)
    suspend fun getFavoritePlaces(): Flow<Set<String>>
}
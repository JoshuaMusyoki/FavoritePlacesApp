package com.nerds.favouriteplaces.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nerds.favouriteplaces.data.local.PlaceDao
import com.nerds.favouriteplaces.data.local.PlaceEntity
import com.nerds.favouriteplaces.domain.model.Places
import com.nerds.favouriteplaces.domain.repository.PlacesRepository
import kotlinx.coroutines.flow.Flow

class PlacesRepositoryImpl(private val placeDao: PlaceDao, private val context: Context) : PlacesRepository {
    private val favorites = mutableListOf<Places>()

    override suspend fun getPlaces(): List<Places> {
        val jsonData = loadJsonFromAsset("places.json") ?: return emptyList()
        val listType = object : TypeToken<List<Places>>() {}.type
        return Gson().fromJson(jsonData, listType)
    }

    override suspend fun getFavouritePlaces(): List<Places> {
        return favorites
    }

    override suspend fun getDbPlaces(): List<PlaceEntity> {
        return placeDao.getAllPlaces()
    }

    override suspend fun getDbFavorites(): List<PlaceEntity> {
        return placeDao.getFavoritePlaces()
    }

    override suspend fun markAsDbFavourite(places: PlaceEntity) {
        val updatedPlace = places.copy(isFavorite = true)
        placeDao.updatePlace(updatedPlace)
    }

    override suspend fun removeDbFavourite(places: PlaceEntity) {
        val updatedPlace = places.copy(isFavorite = false)
        placeDao.updatePlace(updatedPlace)
    }

    override suspend fun getFavoritePlaces(): Flow<Set<String>> {
        TODO("Not yet implemented")
    }

    override suspend fun markAsFavourite(places: Places) {
        if (places !in favorites) favorites.add(places)
    }

    override suspend fun removeFavourite(places: Places) {
        favorites.remove(places)
    }

    private fun loadJsonFromAsset(filename: String): String? {
        return try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }
}
package com.nerds.favouriteplaces.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.nerds.favouriteplaces.data.local.PlaceEntity
import com.nerds.favouriteplaces.domain.model.Places
import com.nerds.favouriteplaces.domain.repository.PlacesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "favourites")

class PlaceRepositoryImpl(private val context: Context): PlacesRepository {
    private val FAVORITE_PLACES_KEY = stringSetPreferencesKey("favorite_places")

    override suspend fun getFavoritePlaces(): Flow<Set<String>> {
        return context.dataStore.data
            .map { preferences -> preferences[FAVORITE_PLACES_KEY] ?: emptySet() }
    }

    suspend fun addFavoritePlace(placeId: String) {
        context.dataStore.edit { preferences ->
            val currentFavorites = preferences[FAVORITE_PLACES_KEY] ?: emptySet()
            preferences[FAVORITE_PLACES_KEY] = currentFavorites + placeId
        }
    }

    suspend fun removeFavoritePlace(placeId: String) {
        context.dataStore.edit { preferences ->
            val currentFavorites = preferences[FAVORITE_PLACES_KEY] ?: emptySet()
            preferences[FAVORITE_PLACES_KEY] = currentFavorites - placeId
        }
    }

    override suspend fun getPlaces(): List<Places> {
        TODO("Not yet implemented")
    }

    override suspend fun getFavouritePlaces(): List<Places> {
        TODO("Not yet implemented")
    }

    override suspend fun markAsFavourite(places: Places) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFavourite(places: Places) {
        TODO("Not yet implemented")
    }

    override suspend fun getDbPlaces(): List<PlaceEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getDbFavorites(): List<PlaceEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun markAsDbFavourite(places: PlaceEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun removeDbFavourite(places: PlaceEntity) {
        TODO("Not yet implemented")
    }
}
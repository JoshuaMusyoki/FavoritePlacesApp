package com.nerds.favouriteplaces.data.services

import com.nerds.favouriteplaces.domain.model.Places
import retrofit2.http.GET

interface PlacesApiService {
    @GET("places")
    suspend fun getPlaces(): List<Places>
}
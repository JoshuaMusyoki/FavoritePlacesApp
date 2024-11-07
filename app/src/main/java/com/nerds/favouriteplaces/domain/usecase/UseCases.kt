package com.nerds.favouriteplaces.domain.usecase

import com.nerds.favouriteplaces.domain.model.Places
import com.nerds.favouriteplaces.domain.repository.PlacesRepository

class GetPlacesUseCase(private val placesRepository: PlacesRepository) {
    suspend operator fun invoke(): List<Places> = placesRepository.getPlaces()
}

class GetFavoritePlacesUseCase(private val repository: PlacesRepository) {
    suspend operator fun invoke(): List<Places> = repository.getFavouritePlaces()
}

class MarkAsFavoriteUseCase(private val repository: PlacesRepository) {
    suspend operator fun invoke(place: Places) = repository.markAsFavourite(place)
}

class RemoveFavoriteUseCase(private val repository: PlacesRepository) {
    suspend operator fun invoke(place: Places) = repository.removeFavourite(place)
}
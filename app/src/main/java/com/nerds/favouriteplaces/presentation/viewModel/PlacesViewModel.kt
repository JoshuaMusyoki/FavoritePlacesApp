package com.nerds.favouriteplaces.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nerds.favouriteplaces.domain.model.Places
import com.nerds.favouriteplaces.domain.repository.PlacesRepository
import com.nerds.favouriteplaces.domain.usecase.GetFavoritePlacesUseCase
import com.nerds.favouriteplaces.domain.usecase.GetPlacesUseCase
import com.nerds.favouriteplaces.domain.usecase.MarkAsFavoriteUseCase
import com.nerds.favouriteplaces.domain.usecase.RemoveFavoriteUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlacesViewModel(
    private val repository: PlacesRepository,
    private val getPlacesUseCase: GetPlacesUseCase,
    private val getFavoritePlacesUseCase: GetFavoritePlacesUseCase,
    private val markAsFavoriteUseCase: MarkAsFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase
): ViewModel() {
    private val _places = MutableStateFlow<List<Places>>(emptyList())
    val places: StateFlow<List<Places>> get() = _places

    private val _favorites = MutableStateFlow<List<Places>>(emptyList())
//    private val _favorites = Flow<Set<List<Places>>> = repository.getDbFavorites()
//    val favoritePlaces: Flow<Set<String>> = repository.getFavoritePlaces
//    ()
    val favorites: StateFlow<List<Places>> get() = _favorites

    init {
        loadPlaces()
        loadFavorites()
    }

    private fun loadPlaces() {
        viewModelScope.launch {
            _places.value = getPlacesUseCase()
        }
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = getFavoritePlacesUseCase()
        }
    }

    fun toggleFavorite(place: Places) {
        viewModelScope.launch {
            if (_favorites.value.contains(place)) {
                removeFavoriteUseCase(place)
                loadFavorites()
            } else {
                markAsFavoriteUseCase(place)
                loadFavorites()
            }
        }
    }
}
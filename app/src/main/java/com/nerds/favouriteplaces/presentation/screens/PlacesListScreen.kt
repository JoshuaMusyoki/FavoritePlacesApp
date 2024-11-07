package com.nerds.favouriteplaces.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nerds.favouriteplaces.presentation.viewModel.PlacesViewModel

@Composable
fun PlacesListScreen(viewModel: PlacesViewModel = hiltViewModel()) {
    val places by viewModel.places.collectAsState()
    val favoritePlaces by viewModel.favorites.collectAsState()

    LazyColumn {
        items(places) { place ->
            PlaceItem(
                places = place,
                isFavorite = favoritePlaces.contains(place),
                onFavoriteClick = { viewModel.toggleFavorite(it) }
            )
        }
    }
}

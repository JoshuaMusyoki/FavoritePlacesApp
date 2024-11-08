package com.nerds.favouriteplaces.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen (val route: String, val title: String, val icon: ImageVector){
    object Splash: Screen("splash_screen", "Favorite Places", Icons.Default.PlayArrow)
    object Home: Screen("home_screen", "Home", Icons.Default.Home)
    object PlaceList: Screen("place_list_screen", "Place List", Icons.Default.Place)
    object PlaceItem: Screen("place_item_screen", "Place Item", Icons.Default.Place)
    object Favourites: Screen("favourites_screen", "Favourites", Icons.Default.Favorite)
}
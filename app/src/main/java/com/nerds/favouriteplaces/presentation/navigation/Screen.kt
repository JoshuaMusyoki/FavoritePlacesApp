package com.nerds.favouriteplaces.presentation.navigation

sealed class Screen (val route: String){
    object Splash: Screen("splash_screen")
    object Home: Screen("home_screen")
    object PlaceList: Screen("place_list_screen")
    object PlaceItem: Screen("place_item_screen")
}
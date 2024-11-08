package com.nerds.favouriteplaces.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.nerds.favouriteplaces.presentation.screens.PlaceItem
import com.nerds.favouriteplaces.presentation.screens.PlacesListScreen
import com.nerds.favouriteplaces.presentation.screens.SplashScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost (
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            PlacesListScreen()
        }
        composable(route = Screen.PlaceList.route) { 
            PlacesListScreen(
                viewModel = TODO()
            )
        }
        
        composable(route = Screen.Favourites.route) { 
            PlaceItem(
                places = TODO(),
                isFavorite = TODO()
            ) { }
        }
        composable(route = Screen.PlaceItem.route) { 
            PlaceItem(
                places = TODO(),
                isFavorite = TODO()
            ) { }
        }
    }
}
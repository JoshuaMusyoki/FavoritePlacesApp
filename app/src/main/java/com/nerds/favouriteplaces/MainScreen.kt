package com.nerds.favouriteplaces

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nerds.favouriteplaces.presentation.navigation.BottomNavigationBar
import com.nerds.favouriteplaces.presentation.navigation.Screen
import com.nerds.favouriteplaces.presentation.screens.PlacesListScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold (
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            Modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route) { PlacesListScreen()  }
            composable(Screen.Favourites.route) { Screen.PlaceItem }
        }
    }
}
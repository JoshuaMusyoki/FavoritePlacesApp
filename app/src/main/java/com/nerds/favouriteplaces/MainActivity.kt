package com.nerds.favouriteplaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.nerds.favouriteplaces.presentation.navigation.SetUpNavGraph
import com.nerds.favouriteplaces.presentation.screens.PlacesListScreen
import com.nerds.favouriteplaces.ui.theme.FavouritePlacesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FavouritePlacesTheme {
                val navController = rememberNavController()
                SetUpNavGraph(navController = navController)
            }
            PlacesListScreen()
        }
    }
}
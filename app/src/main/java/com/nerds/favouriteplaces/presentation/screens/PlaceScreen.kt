package com.nerds.favouriteplaces.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nerds.favouriteplaces.domain.model.Places
import com.nerds.favouriteplaces.presentation.navigation.BottomNavigationBar

@Composable
fun PlaceScreen(
    navController: NavController,
    placeList: List<Places>,
    favoritePlaces: Set<Places>,
    onFavoriteClick: (Places) -> Unit
){
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(placeList.size) {index ->
                val place = placeList[index]

                PlaceItem(
                    places = place,
                    isFavorite = favoritePlaces.contains(place),
                    onFavoriteClick = onFavoriteClick
                )
            }
        }
    }
}

@Preview
@Composable
fun PlaceScreenPreview(){
    val navController = rememberNavController()
    val samplePlaces = listOf(
        Places(id = "Place 1", name = "Sample Place 1", location = "Westlands", imageUrl =""),
        Places(id = "Place 2", name = "Sample Place 2", location = "Parklands", imageUrl =""),
        Places(id = "Place 3", name = "Sample Place 3", location = "Kilimani", imageUrl =""),
    )

    PlaceScreen(
        navController = navController,
        placeList = samplePlaces,
        favoritePlaces = setOf(samplePlaces[0]),
        onFavoriteClick = { }
    )
}
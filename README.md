# Favorite Places App 

## App Features
* Splash Screen: A splash screen with the app logo and a loading animation, which smoothly transitions to the main list screen.
* Display Places List: Fetches a list of places from a JSON file and displays it in a list.
* Mark as Favorite: Users can mark or unmark places as favorites.
* Favorite List: A separate section for users to view all their favorited places.
* Offline Storage: Uses Room Database to store the favorite places, allowing offline access.
* App Navigation: Uses the Navigation Component for smooth navigation between screens.

## Technologies and Libraries

* Programming Language: Kotlin
* UI Framework: Jetpack Compose
* Architecture: MVVM (Model-View-ViewModel)
* Dependency Injection: Hilt
* Network Library: Retrofit (for API fetch capability)
* Image Loading: Coil
* Local Storage: Room Database (for offline storage)
* Project Structure

## The project is organized into four main layers:
* Data: Manages data sources, including Room database entities, DAOs, repositories, and JSON loading logic.
* Domain: Contains the app's business logic, including use cases and repository interfaces.
* Presentation: Manages UI components, such as screens, ViewModels, and UI states.

## Code Walkthrough
* Data Layer
   - Model: Defines the Places data class, representing place data attributes such as name, location, and image URL.
   - Repository: PlacesRepositoryImpl implements PlacesRepository and handles data retrieval from JSON and manages favorites in Room.
   - Local JSON Data: A places.json file is used to load sample data.
   - Room Database: Defines a FavoritesDao for handling favorite place CRUD operations in the database.
* Domain Layer
   - Use Cases: Contains business logic, such as retrieving all places and managing favorites.
   - Repository Interface: Defines an interface (PlacesRepository) to abstract data handling logic for the app.
* Presentation Layer
   - ViewModel: PlacesViewModel provides data to the UI and handles user interactions for adding/removing favorites.
   - UI Screens: Built using Jetpack Compose, includes:
   - SplashScreen: Displays a logo and transitions to the main screen.
   - PlacesListScreen: Displays a list of places with options to mark as favorite.
   - FavoritesScreen: Displays only the user's favorited places.
   - Navigation: Utilizes the Navigation Component to manage navigation between screens.

## Screenshots(Bottom Navigation and SplashScreen)
![](/home/nerd01/Pictures/Screenshots/Screenshot from 2024-11-08 13-02-43.png)
![](/home/nerd01/Pictures/Screenshots/Screenshot from 2024-11-08 13-03-43.png)
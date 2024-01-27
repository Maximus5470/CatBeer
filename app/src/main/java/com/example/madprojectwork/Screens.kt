package com.example.madprojectwork

sealed class Screens(val route: String) {
    data object LoginScreen : Screens("login_screen")
    data object HomeScreen : Screens("home_screen")
    data object RestaurantScreen : Screens("restaurant_screen")
}
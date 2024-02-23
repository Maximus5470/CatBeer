package com.example.madprojectwork

sealed class Screens(
    val route: String
) {
    data object LoginScreen : Screens("login_screen")
    data object HomeScreen : Screens("home_screen")
    data object RestaurantScreen : Screens("restaurant_screen")
    data object Gifload : Screens("loading_screen")
    data object Mainlayout : Screens("mainlayout_screen")
    data object OrderConfirmationPage : Screens("confirmorder_screen")
    data object FAQPage : Screens("faq_screen")
    data object CartPage : Screens("cart_screen")
}
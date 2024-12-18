package com.example.madprojectwork.dataclasses

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.madprojectwork.R

data class home_fooditem_restaurant(
    val name: String,
    val price: Int,
    val stars: Int,
    val reviewNumber: Int,
    val isRestaurant: Boolean,
    val size: Dp,
    val image: Int,
    val distance: String? = "",
    val cuisines: String? = "",
    var isLiked: MutableState<Boolean> = mutableStateOf(false),
    var isOrdered: MutableState<Boolean> = mutableStateOf(false),
)
val foodList = listOf(
    home_fooditem_restaurant(
        name = "Burger1",
        price = 100,
        stars = 3,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.borgir,
    ),
    home_fooditem_restaurant(
        name = "Pizza1",
        price = 100,
        stars = 4,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.pizzaaa
    ),
    home_fooditem_restaurant(
        name = "Sushi1",
        price = 100,
        stars = 4,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.sushi3
    ),
    home_fooditem_restaurant(
        name = "Biryani1",
        price = 100,
        stars = 5,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.biryani
    ),
    home_fooditem_restaurant(
        name = "Kebabs1",
        price = 100,
        stars = 5,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.kebabs3
    ),
    home_fooditem_restaurant(
        name = "Ice Cream1",
        price = 100,
        stars = 5,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.icecream2
    ),
    home_fooditem_restaurant(
        name = "Burger2",
        price = 100,
        stars = 3,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.borgir
    ),
    home_fooditem_restaurant(
        name = "Pizza2",
        price = 100,
        stars = 4,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.pizzaaa
    ),
    home_fooditem_restaurant(
        name = "Sushi2",
        price = 100,
        stars = 4,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.sushi3
    ),
    home_fooditem_restaurant(
        name = "Biryani2",
        price = 100,
        stars = 5,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.biryani
    ),
    home_fooditem_restaurant(
        name = "Kebabs2",
        price = 100,
        stars = 5,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.kebabs3
    ),
    home_fooditem_restaurant(
        name = "Ice Cream2",
        price = 100,
        stars = 5,
        reviewNumber = 100,
        isRestaurant = false,
        size = 190.dp,
        image = R.drawable.icecream2
    ),
)
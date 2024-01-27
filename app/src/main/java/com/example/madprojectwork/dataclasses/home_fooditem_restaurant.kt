package com.example.madprojectwork.dataclasses

import androidx.compose.ui.unit.Dp

data class home_fooditem_restaurant(
    val name: String,
    val price: Int,
    val stars: Int,
    val reviewNumber: Int,
    val isRestaurant: Boolean,
    val size: Dp,
    val image: Int,
    val distance: String? = "",
    val cuisines: String? = ""
)
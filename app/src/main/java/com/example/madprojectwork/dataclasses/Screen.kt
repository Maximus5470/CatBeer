package com.example.madprojectwork.dataclasses

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
@Immutable
sealed class Screen(
    val title: String,
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector
) {
    object Favorites: Screen("Favorites", Icons.Filled.Favorite, Icons.Outlined.FavoriteBorder)
    object Home: Screen("Home", Icons.Filled.Home, Icons.Outlined.Home)
    object Profile: Screen("DashBoard", Icons.Filled.Person, Icons.Outlined.Person)
}
package com.example.madprojectwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.madprojectwork.ui.theme.MadprojectworkTheme
import com.example.madprojectwork.ui.theme.peach_bg

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MadprojectworkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = peach_bg
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.route,
        enterTransition = {
            fadeIn()+slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(200)
            )
        },
        exitTransition = {
            fadeOut()+slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(200)
            )
        },
        popEnterTransition = {
            fadeIn()+slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(200)
            )
        },
        popExitTransition = {
            fadeOut()+slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(200)
            )
        }
    ) {
        composable(Screens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(Screens.RestaurantScreen.route) {
            RestaurantScreen(navController = navController)
        }
        composable(Screens.Gifload.route) {
            Gifload(navController = navController)
        }
        composable(Screens.Mainlayout.route) {
            MainLayout(navController = navController)
        }
        composable(
            route = Screens.OrderConfirmationPage.route,
        ) {
            ConfirmationPage(navController = navController)
        }
        composable(Screens.FAQPage.route) {
            FAQPage(navController = navController)
        }
    }
}

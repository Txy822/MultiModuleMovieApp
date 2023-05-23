package com.sample.apps.multimodulemovieapp.navGraph

//import LoginScreen
//import RegistrationScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.core.common.NavigationItem
//import com.google.accompanist.navigation.animation.composable
import com.apps.feature.movie.ui.screens.HomeScreen
import com.apps.feature.movie.ui.screens.SpacesScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startLocation: String
) {
    NavHost(
        navController = navController,
        startDestination = startLocation
    ) {
        composable(
            route = NavigationItem.HomeScreen.route
        ) {
            HomeScreen()
        }

        composable(
            route = NavigationItem.FavoriteScreen.route
        ) {
            SpacesScreen(navigateTo = {
                navController.navigate(it)
            })
        }
    }
}

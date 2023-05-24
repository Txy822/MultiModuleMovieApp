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
import com.apps.feature.movie.ui.viewmodel.MovieSearchViewModel
import com.apps.features.movie.domain.model.Movie
import com.sample.features.movie_details.ui.screens.DetailScreen

@Composable
fun NavigationGraph(
    viewModel: MovieSearchViewModel,
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
           // val viewModel: MovieSearchViewModel = viewModel()
            HomeScreen(viewModel = viewModel, navController)
        }
        composable(route= NavigationItem.DetailScreen.route ){
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Movie>("movie")

            DetailScreen(navController, movie = result)
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

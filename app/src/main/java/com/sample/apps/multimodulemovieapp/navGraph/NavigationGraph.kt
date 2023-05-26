package com.sample.apps.multimodulemovieapp.navGraph


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.core.common.NavigationItem
import com.apps.feature.movie.ui.screens.HomeScreen
import com.sample.features.profile.ui.screens.ProfileScreen
import com.sample.features.setting.ui.screens.SettingsScreen
import com.apps.feature.movie.ui.viewmodel.MovieSearchViewModel
import com.apps.features.movie.domain.model.Movie
import com.sample.features.favorite.domain.model.FavoriteMovieModel
import com.sample.features.favorite.ui.screens.FavoriteDetailScreen
import com.sample.features.favorite.ui.screens.FavoriteScreen
import com.sample.features.favorite.ui.viewmodel.FavoriteMovieViewModel
import com.sample.features.movie_details.ui.screens.DetailScreen

@Composable
fun NavigationGraph(
    movieViewModel: MovieSearchViewModel,
    favoriteViewModel: FavoriteMovieViewModel,
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
            HomeScreen(viewModel = movieViewModel, navController)
        }
        composable(route= NavigationItem.DetailScreen.route ){
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Movie>("movie")

            DetailScreen(navController, movie = result, favoriteViewModel= favoriteViewModel)
        }
        composable(route= NavigationItem.FavoriteDetailScreen.route ){
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<FavoriteMovieModel>("favorite")
            FavoriteDetailScreen(
                navController,
                movie = result,
                favoriteViewModel = favoriteViewModel
            )
        }

        composable(
            route = NavigationItem.FavoriteScreen.route
        ) {
            FavoriteScreen(favoriteViewModel, navController)
        }
        composable(route= NavigationItem.SettingScreen.route){
           SettingsScreen()
        }
        composable(route = NavigationItem.ProfileScreen.route){
           ProfileScreen()
        }
    }
}

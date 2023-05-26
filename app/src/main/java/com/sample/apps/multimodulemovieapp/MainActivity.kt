package com.sample.apps.multimodulemovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.apps.feature.movie.ui.viewmodel.MovieSearchViewModel
import com.core.common.NavigationItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sample.apps.multimodulemovieapp.navGraph.NavigationGraph
import com.sample.apps.multimodulemovieapp.navGraph.PopBottomNavigation
import com.sample.apps.multimodulemovieapp.ui.theme.MultiModuleMovieAppTheme
import com.sample.features.favorite.ui.viewmodel.FavoriteMovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleMovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    val movieViewModel: MovieSearchViewModel = viewModel()
    val favoriteViewModel: FavoriteMovieViewModel = viewModel()

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.Black)
    Scaffold(
        bottomBar = {
            PopBottomNavigation(
                navController = navController,
                items = listOf(
                    NavigationItem.HomeScreen,
                    NavigationItem.FavoriteScreen,
                    NavigationItem.ProfileScreen,
                    NavigationItem.SettingScreen
                )
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    PaddingValues(
                        0.dp,
                        0.dp,
                        0.dp,
                        innerPadding.calculateBottomPadding()
                    )
                )
        ) {
            // Add Splash Screen here
            NavigationGraph(
                movieViewModel = movieViewModel,
                favoriteViewModel = favoriteViewModel,
                navController = navController,
                startLocation = NavigationItem.HomeScreen.route
            )
        }
    }
}
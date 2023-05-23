package com.sample.apps.multimodulemovieapp

import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.core.common.NavigationItem
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.sample.apps.multimodulemovieapp.navGraph.NavigationGraph
import com.sample.apps.multimodulemovieapp.navGraph.PopBottomNavigation
import com.sample.apps.multimodulemovieapp.ui.theme.MultiModuleMovieAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleMovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    var isVisibleBT by remember {
                        mutableStateOf(true)
                    }
                    Scaffold(
                        bottomBar = {
                            if (isVisibleBT) {
                                PopBottomNavigation(
                                    navController = navController,
                                    items = listOf(
                                        NavigationItem.FavoriteScreen,
                                        NavigationItem.HomeScreen
                                    )
                                )
                            }
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
                            val authToken = true
                            if (authToken) {
                                NavigationGraph(
                                    navController,
                                    NavigationItem.HomeScreen.route
                                )
                            } else {
                                isVisibleBT = true
                                NavigationGraph(
                                    navController,
                                    NavigationItem.FavoriteScreen.route)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MultiModuleMovieAppTheme {
        Greeting("Android")
    }
}
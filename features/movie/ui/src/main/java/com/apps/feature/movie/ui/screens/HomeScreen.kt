package com.apps.feature.movie.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.apps.feature.movie.ui.viewmodel.MovieSearchViewModel


@Composable
fun HomeScreen(
    state: MovieStateHolder,
    viewModel: MovieSearchViewModel
) {

    val result = viewModel.movieList.value

    val query =viewModel.query.collectAsState()

    Column {
        Box(
            contentAlignment = Alignment.Center
        ){
            Text(text ="Home Screen")
        }
    }
}

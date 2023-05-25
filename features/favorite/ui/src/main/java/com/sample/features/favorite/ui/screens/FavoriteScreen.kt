package com.sample.features.favorite.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sample.features.favorite.domain.model.FavoriteMovieModel
import com.sample.features.favorite.ui.viewmodel.FavoriteMovieEvent
import com.sample.features.favorite.ui.viewmodel.FavoriteMovieViewModel

@Composable
fun FavoriteScreen(viewModel: FavoriteMovieViewModel) {
    val favoriteMovieStates by viewModel.favoriteMovieStates.collectAsState()
    val favorites = favoriteMovieStates.favorites
    LazyColumn {
        items(favorites!!.size) { i ->
            MovieItem(movie = favorites[i]) {
                viewModel.onEvent(FavoriteMovieEvent.DeleteFavorite(favorites[i]))
            }
        }
    }
}

@Composable
fun MovieItem(movie: FavoriteMovieModel, onRemoveClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Display movie information here

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = onRemoveClicked,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Remove",
                tint = Color.Red
            )
        }
    }
}

package com.sample.features.favorite.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sample.features.favorite.domain.model.FavoriteMovieModel
import com.sample.features.favorite.domain.model.toFavoriteMovieModel
import com.sample.features.favorite.ui.viewmodel.FavoriteMovieEvent
import com.sample.features.favorite.ui.viewmodel.FavoriteMovieViewModel

@Composable
fun FavoriteScreen(viewModel: FavoriteMovieViewModel) {
    val favoriteMovieStates by viewModel.favoriteMovieStates.collectAsState()
    val favorites = favoriteMovieStates.favorites


    // Launch a coroutine bound to the scope of the composable
    LaunchedEffect(key1 = viewModel, block = {
        viewModel.onEvent(FavoriteMovieEvent.LoadFavorites)
    })

    Scaffold(
        topBar = { topAppBar()}) {
        Log.d("Tag", "Movie Details Screen:$it")
         if (favoriteMovieStates.error.isNotBlank()) {
             Box(
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(20.dp),
                 contentAlignment = Alignment.Center
             ) {
                 Text(text = "Error , No Data")
             }
         } else if (favoriteMovieStates.favorites.isNullOrEmpty()) {
             Box(
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(20.dp),
                 contentAlignment = Alignment.Center
             ) {
                 Text(text = " No Data")
             }
         } else if (!favoriteMovieStates.favorites.isNullOrEmpty()) {

             LazyColumn {
                 items(favorites!!.size) { i ->
                     MovieItem(
                         modifier= Modifier,
                         movie = favorites[i],
                         onRemoveClicked =  {viewModel.onEvent(FavoriteMovieEvent.DeleteFavorite(favorites[i]))},
                         onDetailClicked =  {viewModel.onEvent(FavoriteMovieEvent.AddFavorite(favorites[i]))})
                 }
             }
         } else if (favoriteMovieStates.isLoading) {
             Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                 CircularProgressIndicator()
             }
         }

     }
}


@Composable
fun MovieItem(modifier: Modifier, movie: FavoriteMovieModel, onRemoveClicked: () -> Unit, onDetailClicked:() ->Unit) {
    val movieImageUrl = "https://image.tmdb.org/t/p/w500/${movie?.imgUrl}"
    var displayMenu by remember { mutableStateOf(false) }

    Box(modifier = modifier
        .fillMaxWidth()
        .padding(8.dp)
        .background(Color.LightGray)){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Display movie information here
            Card(
                Modifier
                    .width(250.dp)
                    .height(150.dp),
                elevation = 1.dp,
                shape = RoundedCornerShape(20.dp)
            ) {
                AsyncImage(
                    model = movieImageUrl,
                    contentDescription = "img",
                    contentScale = ContentScale.FillBounds,
                )
            }

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

            Box(modifier = Modifier.background(Color.LightGray)) {
                IconButton(onClick = {displayMenu = !displayMenu }) {
                    Icon(Icons.Default.MoreVert, "")
                }
                DropdownMenu(
                    expanded = displayMenu,
                    onDismissRequest = { displayMenu = false },
                    modifier = Modifier.background(Color.LightGray)
                ) {
                    DropdownMenuItem(onClick = {
                        onRemoveClicked()
                    }) {
                        Text(text = "Delete")
                    }
                    DropdownMenuItem(onClick = {
                        onDetailClicked()
                    }) {
                        Text(text = "Detail")
                    }
                }
            }
        }

    }
}
@Composable
fun topAppBar(){
    TopAppBar(
        title = {
            Text(
                text = " Favorite Movies",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
            )
        },
        backgroundColor = Color.LightGray,
        elevation = 4.dp,
    )
}

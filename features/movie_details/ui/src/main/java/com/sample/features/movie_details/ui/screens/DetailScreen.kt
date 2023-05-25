package com.sample.features.movie_details.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.apps.features.movie.domain.model.Movie
import com.sample.features.favorite.domain.model.toFavoriteMovieModel
import com.sample.features.favorite.ui.viewmodel.FavoriteMovieEvent
import com.sample.features.favorite.ui.viewmodel.FavoriteMovieViewModel


@Composable
fun DetailScreen(navController: NavHostController, movie: Movie?, favoriteViewModel: FavoriteMovieViewModel) {

    val movieImageUrl = "https://image.tmdb.org/t/p/w500/${movie?.imgUrl}"


    Scaffold(
        topBar = {TopAppBar_(navController = navController)}) {
        Log.d("Tag", "Movie Details Screen:$it")
        if (movie == null) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No Data!")
            }
        } else {
            Column(modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())) {

                Card(
                    Modifier.width(400.dp).height(400.dp),
                    elevation = 1.dp,
                    shape = RoundedCornerShape(20.dp)
                ) {
//                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                        AsyncImage(
                            model = movieImageUrl,
                            contentDescription = "img",
                            contentScale = ContentScale.FillBounds,
                        )
//                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(text = movie.title, style = MaterialTheme.typography.h5)
                        Text(text = "Popularity: "+movie.popularity.toString(), style = MaterialTheme.typography.body1)
                        Text(text = "Vote Count: "+movie.voteCount.toString(), style = MaterialTheme.typography.body1)
                        Text(text = "Overview: "+movie.overview, style = MaterialTheme.typography.body1)

                        val isFavorite = false
                        val buttonContent = if (isFavorite) {
                            "Remove from Favorites"
                        } else {
                            "Add to Favorites"
                        }

                        Button(
                            onClick = {
                                if (isFavorite) {
                                    favoriteViewModel.onEvent(FavoriteMovieEvent.DeleteFavorite(movie.toFavoriteMovieModel()))
                                } else {
                                    favoriteViewModel.onEvent(FavoriteMovieEvent.AddFavorite(movie.toFavoriteMovieModel()))
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Text(text = buttonContent)
                        }

                    }
                }
                
            }

        }

    }


}
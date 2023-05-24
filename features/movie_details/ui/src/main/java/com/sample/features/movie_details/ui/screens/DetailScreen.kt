package com.sample.features.movie_details.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.apps.features.movie.domain.model.Movie

//import com.sample.features.movie_details.domain.Movie

@Composable
fun DetailScreen(navController: NavHostController, movie: Movie?) {

    val movieImageUrl = "https://image.tmdb.org/t/p/w500/${movie?.imgUrl}"
    Column(modifier = Modifier.padding(10.dp)) {
        TopAppBarContent(navController)
        Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
               // contentAlignment = Alignment.Center
            ) {
                Text(text = movie?.title.toString())
            }
        Card(Modifier
            .fillMaxWidth(),
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            AsyncImage(
                model = movieImageUrl,
                contentDescription = "img",
                contentScale = ContentScale.Crop
            )
        }
        }
}
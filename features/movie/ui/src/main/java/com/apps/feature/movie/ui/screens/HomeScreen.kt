package com.apps.feature.movie.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.apps.feature.movie.ui.viewmodel.MovieSearchViewModel
import com.apps.features.movie.domain.model.Movie
import com.core.common.NavigationItem

@Composable
fun HomeScreen(
    viewModel: MovieSearchViewModel,
    navController: NavHostController
) {
    val result = viewModel.movieSate.value
    val query by viewModel.query.collectAsState()
    Scaffold(topBar = {}
    ) {
        //add this just to handle padding values
        Log.d("Tag", "Movie Screen: $it")

        Column() {
            Box(modifier = Modifier.fillMaxWidth().background(Color.Black)){
                SearchField(query = query, viewModel = viewModel)
            }
            if (result.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            if (result.error.isNotBlank()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = result.error)
                }
            }
            result.data?.let { movies ->
                if (movies.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Nothing found")
                    }
                } else {
                    LazyVerticalGrid(
                        modifier= Modifier.background(Color.Black),
                        columns = GridCells.Adaptive(minSize = 128.dp),
                        content = {
                            items(movies) { movie ->
                                GridItem(movie) {
                                    navController.currentBackStackEntry?.savedStateHandle?.set(
                                        key = "movie",
                                        value = movie
                                    )
                                    navController.navigate(route = NavigationItem.DetailScreen.route)
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SearchField(query: String, viewModel: MovieSearchViewModel) {
    OutlinedTextField(
        value = query,
        onValueChange = { viewModel.setQuery(it) },
        modifier = Modifier
            .fillMaxWidth().padding(6.dp),
        textStyle = TextStyle(color = Color.White),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White
            )
        },
        placeholder = {
            Text(
                text = "Search...",
                color = Color.White.copy(alpha = 0.6f),
                fontStyle = FontStyle.Italic
            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.Black,
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.White,
            textColor = Color.White,
            placeholderColor = Color.White.copy(alpha = 0.6f)
        ),
        singleLine = true,
        trailingIcon = {
            if (query.isNotEmpty()) {
                Icon(
                    Icons.Default.Clear,
                    contentDescription = "Clear Icon",
                    tint = Color.White,
                    modifier = Modifier.clickable { query.drop(query.length) }
                )
            }
        }
    )
}

@Composable
fun GridItem(movie: Movie, navigateToDetail: () -> Unit) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .border(width = 2.dp, color = Color.White)
            .clickable {
                navigateToDetail()
            }
    ) {
        AsyncImage(
            model = movie.imgUrl,
            contentDescription = "img",
            contentScale = ContentScale.Fit
        )
    }
}


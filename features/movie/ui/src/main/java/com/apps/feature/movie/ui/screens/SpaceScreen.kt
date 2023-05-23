package com.apps.feature.movie.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.apps.feature.movie.ui.viewmodel.FavoriteViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SpacesScreen(
    navigateTo: (String) -> Unit,
    favoriteViewModel: FavoriteViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    Column {
        Box(
        ){
            Text(text= "Favorite Screen")
        }
    }
}
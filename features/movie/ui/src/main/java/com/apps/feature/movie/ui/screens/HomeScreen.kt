package com.apps.feature.movie.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment


@Composable
fun HomeScreen() {
    var hour by remember {
        mutableStateOf(0)
    }
    Column {
        Box(
            contentAlignment = Alignment.Center
        ){
            Text(text ="Home Screen")
        }
    }
}

package com.sample.features.movie_details.ui.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fetures.movie_details.ui.R

@Composable
fun TopAppBar_(navController: NavController) {
    val contextForToast = LocalContext.current.applicationContext
    TopAppBar(
        title = {
            Text(
                text = " Movie Details",
                maxLines = 1,
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5
            )
        },
        actions = {
            IconButton(
                onClick = {
                    Toast.makeText(contextForToast, "No data to share", Toast.LENGTH_LONG).show()
                }

            ) {
                Icon(
                    Icons.Filled.Share, "share icon", tint = Color.White
                )
            }
        },
        backgroundColor = Color.Black,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {
                navController.navigateUp()
            }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Go back",
                    tint = Color.White
                )
            }
        }
    )
}


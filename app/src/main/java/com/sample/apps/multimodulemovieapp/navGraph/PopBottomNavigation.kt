package com.sample.apps.multimodulemovieapp.navGraph

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.core.common.NavigationItem
import com.sample.apps.multimodulemovieapp.R

@Composable
fun PopBottomNavigation(navController : NavController, items : List<NavigationItem>) {
    Column {
        Divider(thickness = 1.dp,color = Color.Black.copy(0.6f))
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.black),
            contentColor = Color.White,
            elevation = 10.dp,
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                        )
                    },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.6f),
                    alwaysShowLabel = true,
                    label =  { Text(text = item.title,
                        fontSize = 16.sp) },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route)
                    },
                )
            }
        }
    }
}
package com.core.common

sealed class NavigationItem(
    val route : String,
    val title : String,
    val icon : Int = R.drawable.ic_home,
) {

    object HomeScreen : NavigationItem(
        route= "home_screen",
        title = "Home",
        icon = R.drawable.ic_home
    )
    object FavoriteScreen : NavigationItem(
        route = "favorite_screen",
        title = "Favorites",
        icon = R.drawable.heart
    )
    object DetailScreen : NavigationItem(
        route = "detail_screen",
        title = "Movie Details"
    )
}

package com.core.common

sealed class NavigationItem(
    val route : String,
    val title : String,
    val icon : Int = R.drawable.ic_baseline_home_24,
) {

    object HomeScreen : NavigationItem(
        route= "home_screen",
        title = "Home",
        icon = R.drawable.ic_baseline_home_24
    )
    object FavoriteScreen : NavigationItem(
        route = "favorite_screen",
        title = "Favorites",
        icon = R.drawable.ic_baseline_favorite_border_24
    )
    object SettingScreen : NavigationItem(
        route = "setting_screen",
        title = "Setting",
        icon = R.drawable.ic_baseline_settings_24
    )
    object ProfileScreen : NavigationItem(
        route = "profile_screen",
        title = "Profile",
        icon = R.drawable.baseline_account_circle_24
    )
    object DetailScreen : NavigationItem(
        route = "detail_screen",
        title = "Movie Details"
    )
}

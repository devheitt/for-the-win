package com.github.for_the_win.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Destinations(
    val route: String,
    val arguments: List<NamedNavArgument>
){
    object Login: Destinations("login", emptyList())
    object SignUp: Destinations("signup", emptyList())
    object Home: Destinations("home", emptyList())
}

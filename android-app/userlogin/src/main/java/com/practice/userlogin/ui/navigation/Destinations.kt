package com.practice.userlogin.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Destinations(
    val route: String,
    val arguments: List<NamedNavArgument>
){
    object Login: Destinations("login", emptyList())
    object SignUp: Destinations("signup", emptyList())
    object Home: Destinations("home", emptyList())
}

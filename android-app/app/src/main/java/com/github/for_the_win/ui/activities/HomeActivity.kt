package com.github.for_the_win.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import com.github.for_the_win.ui.presentation.home.HomeScreen
import com.github.for_the_win.ui.theme.ForthewinTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.github.for_the_win.ui.navigation.Destinations

@ExperimentalAnimationApi
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForthewinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    HomeScreen()
                }
            }
        }
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addHome(){
    composable(
        route = Destinations.Home.route
    ){
        HomeScreen()
    }
}
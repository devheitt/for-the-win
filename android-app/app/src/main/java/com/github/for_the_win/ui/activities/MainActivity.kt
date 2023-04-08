package com.github.for_the_win.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.github.for_the_win.ui.navigation.Destinations
import com.github.for_the_win.ui.presentation.home.HomeScreen
import com.github.for_the_win.ui.presentation.login.LoginScreen
import com.github.for_the_win.ui.presentation.login.LoginViewModel
import com.github.for_the_win.ui.theme.ForthewinTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.practice.userlogin.ui.presentation.login.SignUpScreen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForthewinTheme {
                val navController = rememberAnimatedNavController()

                BoxWithConstraints {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Destinations.Login.route
                    ) {
                        addLogin(navController)

                        addSignUp(navController)

                        addHome()
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addLogin(
    navController: NavHostController
) {
    composable(
        route = Destinations.Login.route,
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { 1000 },
                animationSpec = tween(500)
            )
        },
        exitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { -1000 },
                animationSpec = tween(500)
            )
        },
        popEnterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { -1000 },
                animationSpec = tween(500)
            )
        },
        popExitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { 1000 },
                animationSpec = tween(500)
            )
        }
    ) {
        val viewModel: LoginViewModel = hiltViewModel()

        if (viewModel.state.value.successLogin) {
            LaunchedEffect(key1 = Unit) {
                navController.navigate(Destinations.Home.route) {
                    popUpTo(Destinations.Login.route) { inclusive = true }
                }
            }
        } else {
            LoginScreen(
                state = viewModel.state.value,
                onLogin = viewModel::login,
                onNavigateToSignUp = {
                    navController.navigate(Destinations.SignUp.route)
                },
                onDismissDialog = viewModel::hideErrorDialog
            )
        }

    }
}


@ExperimentalAnimationApi
fun NavGraphBuilder.addSignUp(
    navController: NavHostController
) {
    composable(
        route = Destinations.SignUp.route,
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { 1000 },
                animationSpec = tween(500)
            )
        },
        exitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { -1000 },
                animationSpec = tween(500)
            )
        },
        popEnterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { -1000 },
                animationSpec = tween(500)
            )
        },
        popExitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { 1000 },
                animationSpec = tween(500)
            )
        }
    ) {
        //SignUpScreen()
    }
}


@ExperimentalAnimationApi
fun NavGraphBuilder.addHome(
    navController: NavHostController
) {
    composable(
        route = Destinations.SignUp.route
    ) {
        HomeScreen()
    }
}
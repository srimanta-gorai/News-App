package com.example.news_app.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.news_app.presentation.screen.NewsScreen
import com.example.news_app.viewModel.NewsViewModel


@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun NavGraphHost(viewModel: NewsViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.Home
    ){

        composable<NavigationRoutes.Home> {
            NewsScreen(viewModel,"general",navController)
        }

        composable<NavigationRoutes.India> {
            NewsScreen(
                viewModel, "general",
                navController
            )
        }

        composable<NavigationRoutes.Technology> {
            NewsScreen(viewModel, "technology",navController)
        }

        composable<NavigationRoutes.Entertainment> {
            NewsScreen(viewModel, "entertainment",navController)
        }
    }
}
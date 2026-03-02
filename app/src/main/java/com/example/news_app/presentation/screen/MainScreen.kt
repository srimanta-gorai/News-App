package com.example.news_app.presentation.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.news_app.presentation.navigation.NavGraphHost
import com.example.news_app.viewModel.NewsViewModel

@Composable
fun MainScreen(vm: NewsViewModel) {


    Scaffold(
//        bottomBar = { CategoriesBar(navController) }
    ) { padding ->
        NavGraphHost(vm)
    }
}
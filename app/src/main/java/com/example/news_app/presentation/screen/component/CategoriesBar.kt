package com.example.news_app.presentation.screen.component

import android.service.controls.Control
import android.widget.MediaController
import androidx.compose.foundation.horizontalScroll

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.news_app.presentation.navigation.NavigationRoutes
import com.example.news_app.viewModel.NewsViewModel

@Composable
fun CategoriesBar(navController: NavHostController) {

    val categoryList = listOf(
        "GENERAL",
        "INDIA",
        "ENTERTAINMENT",
        "TECHNOLOGY"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        categoryList.forEach { category->
            Button(onClick = {
                when (category) {

                    "GENERAL" -> navController.navigate(NavigationRoutes.Home)
                    "INDIA" -> navController.navigate(NavigationRoutes.India)
                    "TECHNOLOGY" -> navController.navigate(NavigationRoutes.Technology)
                    "ENTERTAINMENT" -> navController.navigate(NavigationRoutes.Entertainment)
                }
            } ,
                modifier = Modifier.padding(5.dp)) {
                Text(text = category)
            }
        }
    }

}
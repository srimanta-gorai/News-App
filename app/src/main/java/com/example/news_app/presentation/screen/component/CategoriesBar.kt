package com.example.news_app.presentation.screen.component

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
import com.example.news_app.ui.NewsViewModel

@Composable
fun CategoriesBar(newsViewModel: NewsViewModel) {

    val categoryList = listOf(
        "GENERAL",
        "BUSINESS",
        "ENTERTAINMENT",
        "TECHNOLOGY",
        "HEALTH",
        "SCIENCE",
        "SPORTS"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        categoryList.forEach { category->
            Button(onClick = {
            } ,
                modifier = Modifier.padding(5.dp)) {
                Text(text = category)
            }
        }
    }

}
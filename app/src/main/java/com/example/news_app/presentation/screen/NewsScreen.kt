package com.example.news_app.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.news_app.presentation.screen.component.CategoriesBar
import com.example.news_app.ui.NewsViewModel
import com.example.news_app.presentation.screen.component.NewsItem

@Composable
fun NewsScreen(viewModel: NewsViewModel) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    when {
        state.isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        state.error != null -> {
            Text("Error: ${state.error}",modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center))
        }
        else ->{
            Column(modifier = Modifier.fillMaxSize()) {

                CategoriesBar(newsViewModel = viewModel)

                LazyColumn(modifier = Modifier.fillMaxSize()){
                    items(state.news) {artical ->
                        NewsItem(artical)
                    }
                }
            }
        }
    }
}
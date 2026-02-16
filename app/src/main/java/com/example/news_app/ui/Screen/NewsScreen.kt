package com.example.news_app.ui.Screen

import androidx.compose.foundation.layout.Box
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
import com.example.news_app.ui.NewsViewModel

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
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(state.news) {artical ->
                    NewsItem(artical)
                }
//                { article ->
//
//                    Card(modifier = Modifier.fillMaxWidth(),
//                        shape = RoundedCornerShape(12.dp),
//                        elevation = CardDefaults.cardElevation(5.dp)
//                    ) {
//                        Column(modifier = Modifier.padding(10.dp)) {
//                            Text(
//                                text = article.title ?: "No Title",
//                                fontSize = 18.sp,
//                                fontWeight = FontWeight.Bold
//                            )
//                            Spacer(modifier = Modifier.height(5.dp))
//
//                            Text(
//                                text = article.description ?: "No Description",
//                                fontSize = 14.sp,
//                                color = Color.Gray
//                            )
//
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(2.dp))
//                }

            }
        }
    }
}
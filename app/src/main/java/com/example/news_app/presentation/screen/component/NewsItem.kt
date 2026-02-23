package com.example.news_app.presentation.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.news_app.data.model.Article

@Composable
fun NewsItem(article: Article) {
    Card(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = article.urlToImage ?: "data:image/png;base64,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",
                contentDescription = "Article Image",
                modifier = Modifier.size(80.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = article.title ?: "No Title",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = article.description ?: "No Description",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    maxLines = 2
                )


            }

        }

    }
    Spacer(modifier = Modifier.height(2.dp))

}
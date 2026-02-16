package com.example.news_app.ui

import com.example.news_app.data.model.Article
import kotlinx.serialization.Serializable

@Serializable
data class NewsState(
    val isLoading: Boolean = false,
    val news: List<Article> = emptyList(),
    val error: String? = null
)
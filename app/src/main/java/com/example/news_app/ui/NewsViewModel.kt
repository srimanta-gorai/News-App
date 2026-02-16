package com.example.news_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.data.model.NewsModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {

    val ktor = KtorClient.create()
    private val _state = MutableStateFlow(NewsState())
    val state = _state.asStateFlow()

    init {
        getNews()
    }

    fun getNews(){
        viewModelScope.launch {
            try {
                val data =
                    ktor.get("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=cccf54d319934db2bb8b035838d21711")
                        .body<NewsModel>()
                _state.update {
                    it.copy(
                        news = data.articles
                    )
                }
            }catch (e: Exception) {
                _state.value = NewsState(error = e.message)
            }
        }
    }
}
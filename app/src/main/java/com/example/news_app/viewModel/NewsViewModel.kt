package com.example.news_app.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.data.model.NewsModel
import com.example.news_app.viewModel.state.NewsState
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

        getNews("general")
    }

    fun getNews(category : String){

        val api = "https://newsapi.org/v2/top-headlines?country=us&category=$category&apiKey=cccf54d319934db2bb8b035838d21711"
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true,
                    news = emptyList()
                )
            }
            try {
                val data =
                    ktor.get(api)
                        .body<NewsModel>()
//                Log.d("Srimanta", "getNews:$data ")
                _state.update {
                    it.copy(
                        news = data.articles,
                        isLoading = false
                    )
                }
            }catch (e: Exception) {
                _state.value = NewsState(error = e.message,
                    isLoading = false)
            }
        }
    }
}
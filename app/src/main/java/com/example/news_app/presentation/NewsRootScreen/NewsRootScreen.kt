package com.example.news_app.presentation.NewsRootScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.news_app.presentation.navigation.NavGraphHost
import com.example.news_app.presentation.navigation.NavigationRoutes
import com.example.news_app.presentation.navigation.tabList


@Composable
fun NewsRootScreen(
                   navHostController: NavHostController
) {

    Scaffold() { inn ->

        var select by remember { mutableStateOf(NavigationRoutes.AllNews::class.qualifiedName) }

        NavigationRail() {
            tabList.forEachIndexed { index, tab ->

                NavigationRailItem(
                    selected = select == tab,
                    onClick ={
                        select = tab
                        navHostController.navigate(tab ?: "")
                    },
                    icon = {
                        Text(tab ?: "")
                    }

                )
            }
        }

        NavGraphHost(navHostController)
    }

}
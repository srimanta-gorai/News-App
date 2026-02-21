package com.example.news_app.presentation.NewsRootScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.news_app.presentation.navigation.NavGraphHost
import com.example.news_app.presentation.navigation.NavigationRoutes
import com.example.news_app.presentation.navigation.pairList
import com.example.news_app.presentation.navigation.tabList


@Composable
fun NewsRootScreen(
    navHostController: NavHostController
) {

    Scaffold() { inn ->

        var select by remember { mutableStateOf(NavigationRoutes.AllNews::class.qualifiedName) }

      LazyRow() {
            items(pairList) { pair ->

                Row(
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Button(
                        modifier = Modifier,
                        shape = RoundedCornerShape(9.dp),
                        onClick = {
                            select = pair.first
                            navHostController.navigate(pair.first ?: "")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (select == pair.first) Color.Red else Color.Gray
                        ),
                    ) {
                        Text(
                            pair.second
                        )
                    }
                }
            }
        }

        NavGraphHost(navHostController)

    }
}



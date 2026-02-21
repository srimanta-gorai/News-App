package com.example.news_app.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object NavigationRoutes {

    @Serializable
    object AllNews

    @Serializable
    object TechNews

    @Serializable
    object NONENews

    @Serializable
    object RootScreen

}

val tabList = listOf(
    NavigationRoutes.AllNews::class.qualifiedName,
    NavigationRoutes.TechNews::class.qualifiedName,
    NavigationRoutes.NONENews::class.qualifiedName
)

val pairList = listOf<Pair<String? , String>>(
    Pair(NavigationRoutes.AllNews::class.qualifiedName,"All"),
    Pair(NavigationRoutes.TechNews::class.qualifiedName,"Tech"),
    Pair(NavigationRoutes.NONENews::class.qualifiedName,"None")
)
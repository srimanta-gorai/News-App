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

}

val tabList = listOf(NavigationRoutes.AllNews::class.qualifiedName, NavigationRoutes.TechNews::class.qualifiedName, NavigationRoutes.NONENews::class.qualifiedName)
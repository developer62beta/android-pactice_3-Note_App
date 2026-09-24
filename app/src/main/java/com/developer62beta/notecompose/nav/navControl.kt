package com.developer62beta.notecompose.nav

import androidx.navigation.NavHostController

fun navControl(myNavController: NavHostController, route: MyNavRoute) {
    myNavController.navigate(route) {
        popUpTo(myNavController.graph.startDestinationId) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
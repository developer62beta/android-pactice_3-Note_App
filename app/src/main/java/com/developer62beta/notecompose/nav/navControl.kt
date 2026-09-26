package com.developer62beta.notecompose.nav

import androidx.navigation.NavHostController

fun navControl(myNavController: NavHostController, route: MyNavRoute) {
    myNavController.navigate(route) {
        popUpTo(myNavController.graph.startDestinationId) {
            saveState = (route != MyNavRoute.NoteEdit)
        }
        launchSingleTop = true
        restoreState = (route != MyNavRoute.NoteEdit)
    }
}
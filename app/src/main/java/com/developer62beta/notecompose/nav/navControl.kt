package com.developer62beta.notecompose.nav

import androidx.navigation.NavHostController

fun navControl(myNavController: NavHostController, route: MyNavRoute) {
    myNavController.navigate(route) {
        popUpTo(myNavController.graph.startDestinationId) {
            //saveState = (route != MyNavRoute.NoteEdit)
            saveState = false // i don't want to save the state
        }
        launchSingleTop = true
        //restoreState = (route != MyNavRoute.NoteEdit)
        restoreState = false // saveState is false so not need to restore anything
    }
}
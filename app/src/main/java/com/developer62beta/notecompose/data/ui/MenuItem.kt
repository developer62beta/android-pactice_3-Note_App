package com.developer62beta.notecompose.data.ui

import com.developer62beta.notecompose.nav.MyNavRoute

data class MenuItem(

    val title: String,
    val route: MyNavRoute,
)

object MenuItems{
    val items: List<MenuItem> = listOf(
        MenuItem("HOME", MyNavRoute.Home),
        MenuItem("SETTINGS", MyNavRoute.Setting),
        MenuItem("ABOUT", MyNavRoute.About)
    )
}





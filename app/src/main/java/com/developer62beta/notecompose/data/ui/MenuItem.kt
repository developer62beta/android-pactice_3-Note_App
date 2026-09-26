package com.developer62beta.notecompose.data.ui

import com.developer62beta.notecompose.nav.MyNavRoute

data class MenuItem(

    var title: String,
    var route: MyNavRoute,
)

class Item{
    val ites: List<MenuItem> = listOf(
        MenuItem("HOME", MyNavRoute.Home),
        MenuItem("SETTINGS", MyNavRoute.Setting),
        MenuItem("ABOUT", MyNavRoute.About)
    )
}





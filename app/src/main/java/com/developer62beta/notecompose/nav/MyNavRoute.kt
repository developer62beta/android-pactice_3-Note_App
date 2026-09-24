package com.developer62beta.notecompose.nav

import kotlinx.serialization.Serializable

@Serializable
sealed class MyNavRoute{

    @Serializable
    data object Home: MyNavRoute()

    @Serializable
    data object NoteEdit: MyNavRoute()

    @Serializable
    object Search : MyNavRoute()

}
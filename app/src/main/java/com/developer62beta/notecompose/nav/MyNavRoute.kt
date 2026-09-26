package com.developer62beta.notecompose.nav

import kotlinx.serialization.Serializable

@Serializable
sealed class MyNavRoute{

    @Serializable
    data object Home: MyNavRoute()

    @Serializable
    data class NoteEdit(var id: Int, var title: String, var note: String): MyNavRoute()

    @Serializable
    object Search : MyNavRoute()

}
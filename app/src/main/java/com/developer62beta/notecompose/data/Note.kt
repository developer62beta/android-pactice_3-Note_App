package com.developer62beta.notecompose.data


data class Note(
    var id: Int,
    var title: String,
    var note: String? = null
)
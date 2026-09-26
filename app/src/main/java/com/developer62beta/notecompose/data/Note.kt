package com.developer62beta.notecompose.data

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity("note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var note: String? = null
)
package com.developer62beta.notecompose.data.model

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "config_table")
data class ConfigEntity(
    @PrimaryKey
    val id: Int = 1, // We only ever need 1 row for app-wide settings
    val isDarkTheme: Boolean = false
)

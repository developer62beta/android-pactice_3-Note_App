package com.developer62beta.notecompose.repo

import com.developer62beta.notecompose.data.dao.ConfigDao
import com.developer62beta.notecompose.data.model.ConfigEntity
import javax.inject.Inject

class SettingRepo @Inject constructor(
    private val configDao: ConfigDao
) {

    suspend fun updateTheme(isDark: Boolean) {
        // Save using the Entity class
        val config = ConfigEntity(id = 1, isDarkTheme = isDark)
        configDao.insertOrUpdateConfig(config)
    }

    suspend fun getTheme(): Boolean {
        val flag = configDao.getThemeFlag() ?: 0
        return flag == 1 // Convert SQLite integer (0 or 1) to Kotlin Boolean
    }
}
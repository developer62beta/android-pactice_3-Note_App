package com.developer62beta.notecompose.data.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import com.developer62beta.notecompose.data.model.ConfigEntity

@Dao
interface ConfigDao {

    // Insert or update the config entity object
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateConfig(config: ConfigEntity)

    // Query returning an Int (0 or 1) because Room doesn't map raw SQL to Boolean directly
    @Query("SELECT isDarkTheme FROM config_table WHERE id = 1")
    suspend fun getThemeFlag(): Int?
}
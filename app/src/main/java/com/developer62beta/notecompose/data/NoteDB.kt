package com.developer62beta.notecompose.data

import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.developer62beta.notecompose.data.dao.ConfigDao
import com.developer62beta.notecompose.data.dao.NoteDAO
import com.developer62beta.notecompose.data.model.ConfigEntity
import com.developer62beta.notecompose.data.model.Note

@Database(
    entities = [Note::class, ConfigEntity::class], version = 2, exportSchema = false
)
abstract class NoteDB: RoomDatabase(){
    abstract fun noteDao(): NoteDAO
    abstract fun configDao(): ConfigDao
}
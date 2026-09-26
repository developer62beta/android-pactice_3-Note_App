package com.developer62beta.notecompose.data

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase

@Database(
    entities = [Note::class], version = 1, exportSchema = false
)
abstract class NoteDB: RoomDatabase(){
    abstract fun noteDao(): NoteDAO

    companion object{
        @Volatile
        private var INSTANCE: NoteDB? = null

        fun getDB(context: Context): NoteDB{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDB::class.java,
                    "NoteDB"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}
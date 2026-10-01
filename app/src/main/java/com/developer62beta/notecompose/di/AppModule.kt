package com.developer62beta.notecompose.di

import android.content.Context
import androidx.room3.Room
import com.developer62beta.notecompose.data.dao.NoteDAO
import com.developer62beta.notecompose.data.NoteDB
import com.developer62beta.notecompose.data.dao.ConfigDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): NoteDB {
        return Room.databaseBuilder(
            context,
            NoteDB::class.java,
            "NoteDB"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideNoteDAO(db: NoteDB): NoteDAO{
        return db.noteDao()
    }

    @Provides
    fun provideConfigsDAO(db: NoteDB): ConfigDao{
        return db.configDao()
    }
}
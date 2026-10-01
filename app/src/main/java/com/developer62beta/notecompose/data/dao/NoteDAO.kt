package com.developer62beta.notecompose.data.dao

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import androidx.room3.Update
import com.developer62beta.notecompose.data.model.Note

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note")
    suspend fun getAllNotes(): List<Note>

    // Search by title or note content
    @Query("SELECT * FROM note WHERE title LIKE '%' || :searchQuery || '%' OR note LIKE '%' || :searchQuery || '%'")
    suspend fun searchNotes(searchQuery: String): List<Note>
}
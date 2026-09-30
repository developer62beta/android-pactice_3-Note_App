package com.developer62beta.notecompose.repo

import com.developer62beta.notecompose.data.Note
import com.developer62beta.notecompose.data.NoteDAO
import javax.inject.Inject

class Repo @Inject constructor(private val noteDao: NoteDAO){

    suspend fun getAllNote() = noteDao.getAllNotes()

    suspend fun insertNote(note:Note) {
        noteDao.insertNote(note)
    }

    suspend fun updateNote(note:Note) {
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note:Note) {
        noteDao.deleteNote(note)
    }

    suspend fun searchNotes(query: String) = noteDao.searchNotes(query)

}
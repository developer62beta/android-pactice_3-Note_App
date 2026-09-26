package com.developer62beta.notecompose.repo

import android.content.Context
import com.developer62beta.notecompose.data.Note
import com.developer62beta.notecompose.data.NoteDB

class Repo(context: Context){
    private val db = NoteDB.getDB(context)
    private val noteDao = db.noteDao()

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
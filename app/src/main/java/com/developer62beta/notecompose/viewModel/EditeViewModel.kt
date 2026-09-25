package com.developer62beta.notecompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.developer62beta.notecompose.data.Note

class EditeViewModel: ViewModel(){
    // Use mutableStateOf for a single String variable
    var title by mutableStateOf("")
        private set

    var noteData by mutableStateOf("")
        private set

    fun onTitleChanged(newTitle: String) {
        title = newTitle
    }

    fun onNoteDataChanged(newNote: String) {
        noteData = newNote
    }

    fun saveNote(noteViewModel: NoteViewModel) {
        if (title.isNotBlank() || noteData.isNotBlank()) {
            val newNote = Note(
                id = (noteViewModel.note.size + 1), // Simple ID generator
                title = title,
                note = noteData
            )
            noteViewModel.note.add(0, newNote) // Adds it to the top of your list
        }
    }
}
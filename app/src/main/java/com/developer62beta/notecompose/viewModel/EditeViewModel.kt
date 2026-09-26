package com.developer62beta.notecompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.developer62beta.notecompose.data.Note
import com.developer62beta.notecompose.nav.MyNavRoute
import com.developer62beta.notecompose.repo.Repo
import kotlinx.coroutines.launch

class EditeViewModel(cardNote: MyNavRoute.NoteEdit, context: Repo) : ViewModel(){
    // Use mutableStateOf for a single String variable
    var title by mutableStateOf(cardNote.title)
        private set
    private val repo = context

    var noteData by mutableStateOf(cardNote.note)
        private set

    val cardNote1 = cardNote

    fun onTitleChanged(newTitle: String) {
        title = newTitle
    }

    fun onNoteDataChanged(newNote: String) {
        noteData = newNote
    }

    fun saveNote(noteViewModel: NoteViewModel) {
        val isUpdate = cardNote1.id != 0

        if (title.isNotBlank() || noteData.isNotBlank()) {
            val newNote = Note(
                id = if (isUpdate) cardNote1.id else 0,
                title = title,
                note = noteData
            )
            viewModelScope.launch {
                if (isUpdate) repo.updateNote(newNote) else repo.insertNote(newNote)
                noteViewModel.loadNote()
            }
        }
    }

    companion object {
        fun provideFactory(cardNote: MyNavRoute.NoteEdit, repo: Repo): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                EditeViewModel(cardNote, repo)
            }
        }
    }
}
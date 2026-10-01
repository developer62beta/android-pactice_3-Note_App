package com.developer62beta.notecompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.developer62beta.notecompose.data.model.Note
import com.developer62beta.notecompose.nav.MyNavRoute
import com.developer62beta.notecompose.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EditeViewModel @Inject constructor(
    private val repo: Repo,
    savedStateHandle: SavedStateHandle // Automatically receives navigation arguments

) : ViewModel() {

    // Retrieve the type-safe route arguments straight from SavedStateHandle
    private val cardNote = savedStateHandle.toRoute<MyNavRoute.NoteEdit>()
    // Use mutableStateOf for a single String variable
    var title by mutableStateOf(cardNote.title)
        private set

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
}
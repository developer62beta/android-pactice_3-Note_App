package com.developer62beta.notecompose.viewModel


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.developer62beta.notecompose.data.Note
import com.developer62beta.notecompose.repo.Repo
import kotlinx.coroutines.launch

class NoteViewModel(context: Repo) : ViewModel() {

    var note = mutableStateListOf<Note>()
    val repo = context

    init {
        loadNote()
    }

    fun loadNote(){
        viewModelScope.launch {
            val noteList = repo.getAllNote()
            note.clear()
            note.addAll(noteList)
        }
    }

    fun deleteNote(target: Note) {
        viewModelScope.launch {
            repo.deleteNote(target)
            loadNote()
        }
    }

    companion object {
        fun provideFactory(repo: Repo): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                NoteViewModel(repo)
            }
        }
    }
}
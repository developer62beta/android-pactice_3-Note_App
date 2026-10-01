package com.developer62beta.notecompose.viewModel


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer62beta.notecompose.data.model.Note
import com.developer62beta.notecompose.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteViewModel @Inject constructor( private val repo: Repo ) : ViewModel() {

    var note = mutableStateListOf<Note>()

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

}
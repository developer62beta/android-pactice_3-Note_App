package com.developer62beta.notecompose.viewModel


import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer62beta.notecompose.data.Note
import com.developer62beta.notecompose.repo.Repo
import kotlinx.coroutines.launch

class NoteViewModel(context: Context) : ViewModel() {

    var note = mutableStateListOf<Note>()
    val repo = Repo(context)

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
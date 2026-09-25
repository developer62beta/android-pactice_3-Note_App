package com.developer62beta.notecompose.viewModel


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.developer62beta.notecompose.data.Note

class NoteViewModel : ViewModel() {

    var note = mutableStateListOf<Note>()

    init {

        val list = listOf(
            Note(1, "note 1", "this is test 1"),
            Note(2, "note 2", "this is just test 2"),
            Note(3, "note 3", "this is just test 3"),
            Note(3, "note 4", "this is just test 3"),
            Note(3, "note 5", "this is just test 3"),
            Note(3, "note 6", "this is just test 3"),
            Note(3, "note 7", "this is just test 3"),
            Note(3, "note 8", "this is just test 3"),
            Note(3, "note 9", "this is just test 3"),
            Note(3, "note 10", "this is just test 3"),
            Note(3, "note 11", "this is just test 3"),
            Note(3, "note 13", "this is just test 3"),
            Note(1, "hello")
        )

        loadNote(list)
    }

    fun loadNote(list: List<Note> = emptyList()){
        // data base simulation
        note.addAll(list)
    }
}
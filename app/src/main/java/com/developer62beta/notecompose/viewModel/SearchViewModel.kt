package com.developer62beta.notecompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.developer62beta.notecompose.repo.Repo

class SearchViewModel(repo1: Repo) : ViewModel() {
    // State exposed to the UI
    var searchQuery by mutableStateOf("")
        private set

    // Function to update the search query
    fun onSearchQueryChanged(newQuery: String) {
        searchQuery = newQuery
    }

    // Action triggered when the search button/icon is clicked
    fun performSearch(noteViewModel: NoteViewModel) {
        if (!searchQuery.isBlank()) {

            val filteredList = noteViewModel.note.filter {item ->
                item.title.contains(searchQuery, ignoreCase = true) ||
                        (item.note?.contains(searchQuery, ignoreCase = true) == true)
            }
            noteViewModel.note.clear()
            noteViewModel.note.addAll(filteredList)
        }
    }

    companion object {
        fun provideFactory(repo: Repo): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SearchViewModel(repo)
            }
        }
    }
}

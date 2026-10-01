package com.developer62beta.notecompose.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer62beta.notecompose.repo.SettingRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor( private val settingRepo: SettingRepo) : ViewModel() {

    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme.asStateFlow()

    init {
        loadTheme()
    }

    fun loadTheme(){
        viewModelScope.launch {
           _isDarkTheme.value = settingRepo.getTheme()
        }
    }

    fun toggleTheme(isDark: Boolean) {
        _isDarkTheme.value = isDark

        viewModelScope.launch {
            settingRepo.updateTheme(isDark)
        }
    }
}

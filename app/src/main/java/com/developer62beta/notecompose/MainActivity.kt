package com.developer62beta.notecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.developer62beta.notecompose.nav.NavigationGraph
import com.developer62beta.notecompose.ui.theme.NoteComposeTheme
import com.developer62beta.notecompose.viewModel.SettingViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // ✅ Use viewModels() at the Activity class level
    private val settingViewModel: SettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val isDarkTheme by settingViewModel.isDarkTheme.collectAsState()

            NoteComposeTheme(darkTheme = isDarkTheme) {
                NavigationGraph(settingViewModel)
            }
        }
    }
}


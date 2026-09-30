package com.developer62beta.notecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.developer62beta.notecompose.nav.NavigationGraph
import com.developer62beta.notecompose.ui.theme.NoteComposeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteComposeTheme {
                NavigationGraph()
            }
        }
    }
}


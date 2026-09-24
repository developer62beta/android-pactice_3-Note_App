package com.developer62beta.notecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.developer62beta.notecompose.data.Note
import com.developer62beta.notecompose.nav.NavigationGraph
import com.developer62beta.notecompose.ui.theme.NoteComposeTheme

class MainActivity : ComponentActivity() {

    val list: List<Note> = listOf(
        Note(1, "note1", "this is just test 1"),
        Note(2, "note2", "this is just test 2"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
        Note(3, "note3", "this is just test 3"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteComposeTheme {
               //Greeting("hello")
            // NoteScreen(list)
                NavigationGraph()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteComposeTheme {
        NavigationGraph()
    }
}
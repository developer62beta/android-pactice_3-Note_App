package com.developer62beta.notecompose.myUI

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developer62beta.notecompose.data.Note
import com.developer62beta.notecompose.data.ui.TopBarItem
import com.developer62beta.notecompose.nav.MyNavRoute
import com.developer62beta.notecompose.nav.navControl
import com.developer62beta.notecompose.viewModel.NoteViewModel

@Composable
fun NoteScreen(
    myNavController: NavHostController,
    noteScreen: NoteViewModel
) {

    var deleteNote: Note? by remember { mutableStateOf(null) }
    val navItem = TopBarItem("Search", Icons.Default.Search, MyNavRoute.Search)


    Scaffold(
        topBar = { NoteTopBar(navItem, myNavController) },
        floatingActionButton = { NoteFloatingActionButton(myNavController) }
    ) { innerPadding ->

        // Show empty state if there are no notes
        if (noteScreen.note.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No notes yet.\nTap '+' to create one!",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        } else {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = 8.dp,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(noteScreen.note) { note ->
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        shape = RoundedCornerShape(16.dp), // Modern smooth rounded corners
                        modifier = Modifier
                            .combinedClickable(
                                onClick = {
                                    navControl(
                                        myNavController,
                                        MyNavRoute.NoteEdit(note.id, note.title, note.note ?: "")
                                    )
                                },
                                onLongClick = {
                                    deleteNote = note
                                }
                            )
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF1E293B),
                            contentColor = Color(0xFFF8FAFC)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp)
                        ) {
                            // Title
                            if (note.title.isNotBlank()) {
                                Text(
                                    text = note.title,
                                    modifier = Modifier.fillMaxWidth(),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                            }

                            // Body Content (truncated so cards don't get too massive)
                            if (!note.note.isNullOrBlank()) {
                                Text(
                                    text = note.note ?: "",
                                    modifier = Modifier.fillMaxWidth(),
                                    fontSize = 14.sp,
                                    color = Color(0xFF94A3B8), // Slightly muted text color for body
                                    maxLines = 6, // Prevents giant cards
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    deleteNote?.let {target ->
        DeleteNoteDialog(
            note = target,
            onDismiss = { deleteNote = null },
            onConfirm = {
                noteScreen.deleteNote(target) // Make sure this deletes function exists in NoteViewModel
                deleteNote = null
            }
        )
    }
}


@Composable
fun DeleteNoteDialog(
    note: Note,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Delete Note") },
        text = { Text("Are you sure you want to delete '${note.title}'?") },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text("Delete", color = Color.Red)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
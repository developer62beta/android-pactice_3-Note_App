package com.developer62beta.notecompose.myUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developer62beta.notecompose.nav.MyNavRoute
import com.developer62beta.notecompose.nav.navControl
import com.developer62beta.notecompose.viewModel.EditeViewModel
import com.developer62beta.notecompose.viewModel.NoteViewModel

@Composable
fun NoteEdite(myNavController: NavHostController, noteViewModel: NoteViewModel, editeViewModel: EditeViewModel = EditeViewModel()) {
    val navItem = TopBarItem("Note",Icons.Default.Save, MyNavRoute.Home)

    Scaffold(
        topBar = {
            NoteTopBar(
                navItem,
                myNavController,
                onActionClick = {
                    // 1. Save note to the shared NoteViewModel
                    editeViewModel.saveNote(noteViewModel)
                    // 2. Navigate back to Home
                    navControl(myNavController, MyNavRoute.Home)
                }
                )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize(),

        ) {
            OutlinedTextField(
                value = editeViewModel.title,
                onValueChange = { editeViewModel.onTitleChanged(it)},
                singleLine = true,
                placeholder = { Text(text = "Tittle ...", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = editeViewModel.noteData,
                onValueChange = { editeViewModel.onNoteDataChanged(it)},
                label = { Text(text = "Write note here ...", fontSize = 18.sp) },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
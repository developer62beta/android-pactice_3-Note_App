package com.developer62beta.notecompose.myUI

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developer62beta.notecompose.nav.MyNavRoute
import com.developer62beta.notecompose.nav.navControl
import com.developer62beta.notecompose.viewModel.EditeViewModel
import com.developer62beta.notecompose.viewModel.NoteViewModel

@Composable
fun NoteEdit( // Fixed typo from NoteEdite to NoteEdit
    myNavController: NavHostController,
    noteViewModel: NoteViewModel,
    cardNote: MyNavRoute.NoteEdit,
    context: Context,
    editeViewModel: EditeViewModel = EditeViewModel(cardNote, context)
) {
    val navItem = TopBarItem("Note", Icons.Default.Save, MyNavRoute.Home)

    Scaffold(
        topBar = {
            NoteTopBar(
                navItem,
                myNavController,
                onActionClick = {
                    editeViewModel.saveNote(noteViewModel)
                    navControl(myNavController, MyNavRoute.Home)
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp), // Added outer padding for cleaner margins
        ) {
            // Title Input Field
            OutlinedTextField(
                value = editeViewModel.title,
                onValueChange = { editeViewModel.onTitleChanged(it) },
                singleLine = true,
                placeholder = {
                    Text(text = "Title...", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                },
                modifier = Modifier.fillMaxWidth(),
                // Optional: remove borders for title if you want a cleaner look, or keep OutlinedTextField
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(12.dp)) // Space between title and content

            // Main Content Input Field
            OutlinedTextField(
                value = editeViewModel.noteData,
                onValueChange = { editeViewModel.onNoteDataChanged(it) },
                placeholder = {
                    Text(text = "Write your note here...", fontSize = 16.sp)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Safely fills remaining space instead of fillMaxSize()
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
        }
    }
}
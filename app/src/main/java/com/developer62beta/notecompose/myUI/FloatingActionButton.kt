package com.developer62beta.notecompose.myUI

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.developer62beta.notecompose.nav.MyNavRoute
import com.developer62beta.notecompose.nav.navControl

@Composable
fun NoteFloatingActionButton(myNavController: NavHostController) {
    FloatingActionButton(
        onClick = {
            // Navigates to NoteEdit with ID 0 and empty strings for a new note
            navControl(myNavController, MyNavRoute.NoteEdit(0, "", ""))
        },
        containerColor = Color(0xFF3B82F6), // A vibrant modern blue
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add New Note"
        )
    }
}
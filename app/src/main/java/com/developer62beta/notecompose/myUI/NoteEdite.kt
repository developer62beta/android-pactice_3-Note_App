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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developer62beta.notecompose.nav.MyNavRoute

@Composable
fun NoteEdite(myNavController: NavHostController) {
    val navItem = TopBarItem("Note",Icons.Default.Save, MyNavRoute.Home)
    var tittle by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }

    Scaffold(
        topBar = { NoteTopBar( navItem, myNavController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize(),

        ) {
            OutlinedTextField(
                value = tittle,
                onValueChange = { tittle = it },
                singleLine = true,
                placeholder = { Text(text = "Tittle ...", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = note,
                onValueChange = { note = it},
                label = { Text(text = "Write note here ...", fontSize = 18.sp) },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
package com.developer62beta.notecompose.myUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developer62beta.notecompose.data.Note
import com.developer62beta.notecompose.nav.MyNavRoute
import com.developer62beta.notecompose.nav.navControl

@Composable
fun NoteScreen(myNavController: NavHostController) {

    val list1: List<Note> = listOf(
        Note(1, "note 1", "this is test 1"),
        Note(2, "note 2", "this is just test 2"),
        Note(3, "note 3", "this is just test 3"),
        Note(3, "note 4", "this is just test 3"),
        Note(3, "note 5", "this is just test 3"),
        Note(3, "note 6", "this is just test 3"),
        Note(3, "note 7", "this is just test 3"),
        Note(3, "note 8", "this is just test 3"),
        Note(3, "note 9", "this is just test 3"),
        Note(3, "note 10", "this is just test 3"),
        Note(3, "note 11", "this is just test 3"),
        Note(3, "note 13", "this is just test 3"),
        Note(1,"hello")
    )

    val navItem = TopBarItem("Search",Icons.Default.Search, MyNavRoute.Search)
    Scaffold(
        topBar = { NoteTopBar( navItem, myNavController) },
        floatingActionButton = { FloatingActionButton(myNavController) }
    ) {innerPadding ->

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(list1){note ->
                Card(
                    onClick = { navControl(myNavController, MyNavRoute.NoteEdit) },
                    elevation = CardDefaults.cardElevation(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1E293B),
                        contentColor = Color(0xFFF8FAFC)
                    )
                ) {
                    // Column is required to stack multiple items vertically inside the Card
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp) // Add internal padding for the whole card content
                    ) {
                        Text(
                            text = note.title,
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Cursive,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Only shows the text if note.note is not null and not blank
                        if (!note.note.isNullOrBlank()) Text(
                                text = note.note?:"",
                                modifier = Modifier.fillMaxWidth(),
                            fontFamily = FontFamily.Cursive
                            )
                    }
                }
            }
        }
    }
}



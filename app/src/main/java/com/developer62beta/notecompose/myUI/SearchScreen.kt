package com.developer62beta.notecompose.myUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.developer62beta.notecompose.nav.MyNavRoute
import com.developer62beta.notecompose.nav.navControl

@Composable
fun SearchScreen(myNavController: NavHostController) {

    val navItem = TopBarItem("Search", Icons.Default.Search, MyNavRoute.Home)
    var search by remember { mutableStateOf("") }

    Scaffold(
        topBar = { NoteTopBar(navItem,myNavController) }
    ) { innerPadding ->

        Row(
            modifier = Modifier.padding(innerPadding)
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = search,
                onValueChange = { search = it},
                placeholder = { Text(text = " Search ... ") },
                modifier = Modifier.height(60.dp)
            )

            IconButton (
                onClick = { navControl(myNavController, navItem.route) },
                modifier = Modifier.size(60.dp)
                    .background(
                        color = Color.Blue
                    ),
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Blue
                ),

                shape = IconButtonDefaults.outlinedShape

            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(40.dp),

                )
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Test(){
    val myNavController = rememberNavController()
    SearchScreen(myNavController)
}
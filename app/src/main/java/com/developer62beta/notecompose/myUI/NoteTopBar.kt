package com.developer62beta.notecompose.myUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developer62beta.notecompose.nav.navControl

@Composable
fun NoteTopBar(
    navItem: TopBarItem,
    myNavController: NavHostController,
    onActionClick: (() -> Unit)? = null // <-- Add this parameter
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)
            .statusBarsPadding() // <-- 2. Automatically pushes content down below the status bar
            .height(60.dp)
            .padding(horizontal = 16.dp), // Optional: adds a bit of inner side spacing
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton (
            onClick = { },
            modifier = Modifier.size(60.dp) // Makes the entire button larger
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Search Icon",
                tint = Color.White,
                modifier = Modifier.size(40.dp) // Make the inner icon bigger too
            )
        }

        Text(
            text = "Notes",
            color = Color.White,
            fontSize = 30.sp
            )

        IconButton(
            onClick = {
                        if (onActionClick != null) {
                            onActionClick()
                        } else {
                            navControl(myNavController, navItem.route)
                        }
                      },
            modifier = Modifier.size(60.dp) // Makes the entire button larger
        ) {
            Icon(
                imageVector = navItem.icon,
                contentDescription = "Search Icon",
                tint = Color.White,
                modifier = Modifier.size(40.dp) // Make the inner icon bigger too
            )
        }

    }
}


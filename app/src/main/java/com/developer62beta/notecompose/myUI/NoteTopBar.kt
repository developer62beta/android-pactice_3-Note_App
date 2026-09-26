package com.developer62beta.notecompose.myUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developer62beta.notecompose.data.ui.MenuItem
import com.developer62beta.notecompose.data.ui.MenuItems
import com.developer62beta.notecompose.data.ui.TopBarItem
import com.developer62beta.notecompose.nav.navControl

@Composable
fun NoteTopBar(
    navItem: TopBarItem,
    myNavController: NavHostController,
    onActionClick: (() -> Unit)? = null,
    menuItem: List<MenuItem> = MenuItems.items
) {
    var extendedState by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF1E3A8A))
            .statusBarsPadding()
            .height(60.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Menu button + Dropdown
        Box {
            IconButton(
                onClick = { extendedState = true },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            DropdownMenu(
                expanded = extendedState,
                onDismissRequest = { extendedState = false },
                containerColor = Color(0xFF1E3A8A),
                modifier = Modifier.padding(0.dp)
            ) {

                menuItem.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(item.title, color = Color.White) },
                        onClick = {
                            extendedState = false
                            navControl(myNavController, item.route)
                        }
                    )
                }
            }
        }

        // Title
        Text(
            text = "Notes",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        // Right action button (Search / Save)
        IconButton(
            onClick = {
                if (onActionClick != null) {
                    onActionClick()
                } else {
                    navControl(myNavController, navItem.route)
                }
            },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = navItem.icon,
                contentDescription = navItem.title,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}
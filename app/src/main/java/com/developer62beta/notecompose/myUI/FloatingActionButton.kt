package com.developer62beta.notecompose.myUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.developer62beta.notecompose.nav.MyNavRoute
import com.developer62beta.notecompose.nav.navControl

@Composable
fun FloatingActionButton(myNavController: NavHostController) {
    IconButton(
        onClick = { navControl(myNavController, MyNavRoute.NoteEdit) },
        modifier = Modifier.requiredSize(45.dp)
    ){
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Floating Action Button",
            modifier = Modifier.background(
                color = Color.Blue
            )
                .size(45.dp),
            Color.White
        )
    }
}
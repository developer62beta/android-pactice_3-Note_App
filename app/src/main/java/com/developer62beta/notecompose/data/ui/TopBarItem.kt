package com.developer62beta.notecompose.data.ui

import androidx.compose.ui.graphics.vector.ImageVector
import com.developer62beta.notecompose.nav.MyNavRoute

data class TopBarItem(
    var title: String,
    var icon: ImageVector,
    var route: MyNavRoute
)
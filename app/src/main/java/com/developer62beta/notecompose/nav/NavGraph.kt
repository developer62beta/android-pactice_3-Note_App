package com.developer62beta.notecompose.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developer62beta.notecompose.myUI.NoteEdite
import com.developer62beta.notecompose.myUI.NoteScreen
import com.developer62beta.notecompose.myUI.SearchScreen

@Composable
fun NavigationGraph(){
    val myNavController = rememberNavController()

    NavHost(
        navController = myNavController,
        startDestination = MyNavRoute.Home
    ){

        composable<MyNavRoute.Home>{
            NoteScreen(myNavController)
        }

        composable<MyNavRoute.NoteEdit>{
            NoteEdite(myNavController)
        }

        composable<MyNavRoute.Search> {
            SearchScreen(myNavController)
        }
    }
}
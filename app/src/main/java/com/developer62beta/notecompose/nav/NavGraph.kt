package com.developer62beta.notecompose.nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.developer62beta.notecompose.myUI.NoteEdit
import com.developer62beta.notecompose.myUI.NoteScreen
import com.developer62beta.notecompose.myUI.SearchScreen
import com.developer62beta.notecompose.viewModel.NoteViewModel

@Composable
fun NavigationGraph( context: Context, noteViewModel: NoteViewModel = NoteViewModel(context)){

    val myNavController = rememberNavController()

    NavHost(
        navController = myNavController,
        startDestination = MyNavRoute.Home
    ){

        composable<MyNavRoute.Home>{
            NoteScreen(myNavController, noteViewModel)
        }

        composable<MyNavRoute.NoteEdit>{backStackEntry ->
            val noteData = backStackEntry.toRoute<MyNavRoute.NoteEdit>()
            NoteEdit(myNavController, noteViewModel, noteData, context)
        }

        composable<MyNavRoute.Search> {

            SearchScreen(myNavController, noteViewModel)
        }
    }
}
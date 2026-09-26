package com.developer62beta.notecompose.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.developer62beta.notecompose.myUI.AboutScreen
import com.developer62beta.notecompose.myUI.NoteEdit
import com.developer62beta.notecompose.myUI.NoteScreen
import com.developer62beta.notecompose.myUI.SearchScreen
import com.developer62beta.notecompose.myUI.SettingScreen
import com.developer62beta.notecompose.repo.Repo
import com.developer62beta.notecompose.viewModel.EditeViewModel
import com.developer62beta.notecompose.viewModel.NoteViewModel
import com.developer62beta.notecompose.viewModel.SearchViewModel

@Composable
fun NavigationGraph(){

    val context = LocalContext.current.applicationContext
    val repo = remember { Repo(context) }

    // Clean and reusable factory call
    val noteViewModel: NoteViewModel = viewModel(
        factory = NoteViewModel.provideFactory(repo)
    )

    val searchViewModel: SearchViewModel = viewModel(
        factory = SearchViewModel.provideFactory(repo)
    )

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
            val editeViewModel: EditeViewModel = viewModel(
                factory = EditeViewModel.provideFactory(noteData, repo)
            )

            NoteEdit(myNavController, noteViewModel,editeViewModel)
        }

        composable<MyNavRoute.Search> {

            SearchScreen(myNavController, noteViewModel,searchViewModel)
        }

        composable<MyNavRoute.About> {
            AboutScreen()
        }

        composable<MyNavRoute.Setting> {
            SettingScreen()
        }
    }
}
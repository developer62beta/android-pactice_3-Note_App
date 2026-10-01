package com.developer62beta.notecompose.nav

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developer62beta.notecompose.myUI.AboutScreen
import com.developer62beta.notecompose.myUI.NoteEdit
import com.developer62beta.notecompose.myUI.NoteScreen
import com.developer62beta.notecompose.myUI.SearchScreen
import com.developer62beta.notecompose.myUI.SettingScreen
import com.developer62beta.notecompose.viewModel.EditeViewModel
import com.developer62beta.notecompose.viewModel.NoteViewModel
import com.developer62beta.notecompose.viewModel.SearchViewModel
import com.developer62beta.notecompose.viewModel.SettingViewModel

@Composable
fun NavigationGraph(settingViewModel: SettingViewModel) {


    // Clean and reusable factory call
    val noteViewModel: NoteViewModel = hiltViewModel()
    val searchViewModel: SearchViewModel = hiltViewModel()
    val myNavController = rememberNavController()

    NavHost(
        navController = myNavController,
        startDestination = MyNavRoute.Home
    ){

        composable<MyNavRoute.Home>{
            NoteScreen(myNavController, noteViewModel)
        }

        composable<MyNavRoute.NoteEdit>{

            val editeViewModel: EditeViewModel = hiltViewModel()
            NoteEdit(myNavController, noteViewModel,editeViewModel)
        }

        composable<MyNavRoute.Search> {

            SearchScreen(myNavController, noteViewModel,searchViewModel)
        }

        composable<MyNavRoute.About> {
            AboutScreen()
        }

        composable<MyNavRoute.Setting> {
            SettingScreen(settingViewModel)
        }
    }
}
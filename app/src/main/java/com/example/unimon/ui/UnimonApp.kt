package com.example.unimon.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unimon.ui.view.HomeScreen
import com.example.unimon.ui.screen.MenuScreen
import com.example.unimon.ui.view.TitleScreen

@Composable
fun UnimonApp(){
    Navigation()
}

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "TitleScreen"
    ){
        composable("TitleScreen"){
            TitleScreen(
                navigateToHome = { navController.navigate("HomeScreen") }
            )
        }
        composable("HomeScreen"){
            HomeScreen(
                navigateToMenu = { navController.navigate("MenuScreen") {popUpTo("HomeScreen") }},
                viewModel = viewModel()
            )
        }
        composable("MenuScreen") {
            MenuScreen(
                navigateToHome = { navController.navigate("HomeScreen") },
                viewModel = viewModel()
            )
        }
    }
}
package com.example.unimon.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unimon.ui.screen.HomeScreen
import com.example.unimon.ui.screen.Menu
import com.example.unimon.ui.screen.TitleScreen

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
//            navigateToMenu = { navController.navigate("Menu") }
            )
        }
        composable("Menu") {
            Menu()
        }
    }
}
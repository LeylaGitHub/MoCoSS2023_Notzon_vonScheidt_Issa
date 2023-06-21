package com.example.unimon.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unimon.ui.view.HomeScreen
import com.example.unimon.ui.screen.MenuScreen
import com.example.unimon.ui.screen.TitleScreen
import com.example.unimon.ui.screen.LightOutHomeScreen

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
                navigateToMenu = { navController.navigate("MenuScreen") {popUpTo("HomeScreen") }}
            )
        }
        composable("MenuScreen") {
            MenuScreen(
                navigateToHome = { navController.navigate("HomeScreen") },
                navigateToLightOutHome = { navController.navigate("LightOutHomeScreen") }
            )
        }
        composable("LightOutHomeScreen") {
            LightOutHomeScreen(
                navigateToMenu = {navController.navigate("MenuScreen")}
            )
        }
    }
}
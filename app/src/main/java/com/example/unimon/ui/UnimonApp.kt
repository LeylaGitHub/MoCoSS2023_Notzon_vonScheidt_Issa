package com.example.unimon.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unimon.PreferenceDatastore
import com.example.unimon.ui.screen.HomeScreen
import com.example.unimon.ui.screen.MenuScreen
import com.example.unimon.ui.screen.TitleScreen

@Composable
fun UnimonApp(preferenceDatastore: PreferenceDatastore){
    Navigation(preferenceDatastore)
}

@Composable
fun Navigation(preferenceDatastore: PreferenceDatastore){
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
                navigateToMenu = { navController.navigate("MenuScreen") },
                preferenceDatastore
            )
        }
        composable("MenuScreen") {
            MenuScreen(
                navigateToHome = { navController.navigate("HomeScreen") }
            )
        }
    }
}
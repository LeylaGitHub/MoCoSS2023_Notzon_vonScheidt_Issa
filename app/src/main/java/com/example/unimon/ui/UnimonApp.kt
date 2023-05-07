package com.example.unimon.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unimon.ui.screen.HomeScreen
import com.example.unimon.ui.screen.TitleScreen

@Composable
fun UnimonApp(){
    Navigation()
}

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "TitleScreen"){
        composable("TitleScreen"){
            TitleScreen(navController = navController)
        }
        composable("HomeScreen"){
            HomeScreen(navController = navController)
        }
    }
}
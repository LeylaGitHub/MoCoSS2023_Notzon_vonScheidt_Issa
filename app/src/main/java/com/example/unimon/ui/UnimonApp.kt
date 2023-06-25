package com.example.unimon.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unimon.ui.view.HomeScreen
import com.example.unimon.ui.screen.TitleScreen
import com.example.unimon.ui.view.MenuScreen
import com.example.unimon.ui.view.QuizScreen
import com.example.unimon.ui.view.StudyScreen

@Composable
fun UnimonApp() {
    Navigation()
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "TitleScreen"
    ) {
        composable("TitleScreen") {
            TitleScreen(
                navigateToHome = { navController.navigate("HomeScreen") }
            )
        }
        composable("HomeScreen") {
            HomeScreen(
                navigateToMenu = { navController.navigate("MenuScreen") }
            )
        }
        composable("MenuScreen") {
            MenuScreen(
                navigateToHome = { navController.navigate("HomeScreen") },
                navigateToStudy = { navController.navigate("StudyScreen") }
            )
        }

        composable("StudyScreen") {
            StudyScreen(
                navigateToMenu = { navController.navigate("MenuScreen") },
                navigateToQuiz = { category: String ->  navController.navigate("QuizScreen/$category") }
            )
        }

        composable("QuizScreen/{category}") {
            QuizScreen(
                navigateToStudy = { navController.navigate("StudyScreen") },
                category = it.arguments!!.getString("category")!! // TODO Improve null handling?
            )
        }
    }
}
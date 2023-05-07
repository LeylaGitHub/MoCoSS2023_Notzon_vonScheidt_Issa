package com.example.unimon.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TitleScreen(navController: NavController){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            navController.navigate("HomeScreen")
        }) {
            Text( text = "Click to Start")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TitleScreenPreview(){
    TitleScreen(rememberNavController())
}
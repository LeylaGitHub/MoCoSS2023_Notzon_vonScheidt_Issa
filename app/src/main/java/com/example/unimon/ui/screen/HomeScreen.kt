package com.example.unimon.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unimon.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Card(
        Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(20.dp)
        ) {
            Text("Name: ", fontSize = 20.sp, fontWeight = Bold, color = Color.Black)
            Text("Level: ", fontSize = 20.sp, fontWeight = Bold, color = Color.Black)
        }
    }
    /*    Box(
            Modifier.padding(20.dp),
            Alignment.Center
        ){
            Image(
                painterResource(R.mipmap.unimon_standard),
                "unimon_standard",
                Modifier.size(300.dp)
            )
        }*/
    Row(
        Modifier
            .fillMaxSize()
//            .background(Color.White)
            .padding(20.dp),
        Arrangement.SpaceEvenly,
        Alignment.Bottom
    ) {
        Surface(
            Modifier
                .width(70.dp)
                .height(70.dp),
            border = BorderStroke(2.dp, Color.Black),
            shape = CircleShape
        ) {
            Text(
                "Körper",
                Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontWeight = Bold
            )
        }
        Surface(
            Modifier
                .width(70.dp)
                .height(70.dp),
            CircleShape
        ) {
            Image(
                painterResource(R.mipmap.geist_icon),
                "geist_icon",
            )
        }
        Surface(
            Modifier
                .width(70.dp)
                .height(70.dp),
            border = BorderStroke(2.dp, Color.Black),
            shape = CircleShape
        ) {
            Text(
                "Sozial",
                Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontWeight = Bold
            )
        }
        Surface(
            Modifier
                .width(70.dp)
                .height(70.dp),
            border = BorderStroke(2.dp, Color.Black),
            shape = CircleShape
        ) {
            Text(
                "Schlaf",
                Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontWeight = Bold
            )
        }
    }
}

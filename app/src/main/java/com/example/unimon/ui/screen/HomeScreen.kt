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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unimon.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Popup

@Composable
fun HomeScreen(
    navigateToMenu: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Stats()
        Box(modifier = Modifier.weight(1f)) {
            ImageContainer(
            )
            Box(modifier = Modifier.align(Alignment.BottomEnd)) {
                MenuButton(navigateToMenu)
            }
        }
        BottomRow()
    }
}

@Composable
fun Stats() {
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

@Composable
fun ImageContainer(
) {
    Box {
        Image(
            painterResource(R.drawable.unimon___home),
            "unimon_background_home",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Image(
            painterResource(R.drawable.unimon_standard),
            "unimon_standard",
            Modifier
                .size(425.dp)
                .scale(1.5f)
                .offset(y = 80.dp)
        )
    }
}

@Composable
fun MenuButton(
    navigateToMenu: () -> Unit
) {
    FloatingActionButton(
        onClick = navigateToMenu,
        modifier = Modifier
            .padding(15.dp)
            .size(70.dp, 70.dp),
        shape = CircleShape,
        containerColor = Color.White,
        contentColor = Color.Black,
        elevation = FloatingActionButtonDefaults.elevation()
    ) {
        Icon(
            Icons.Outlined.Menu,
            modifier = Modifier.scale(1.8f),
            contentDescription = "Menu_Button"
        )
    }
}

@Composable
fun BottomRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(20.dp),
        Arrangement.SpaceEvenly,
        Alignment.Bottom
    ) {
        PopUpButton(R.drawable.placeholder, "100/100", Color.Green)
        PopUpButton(R.drawable.placeholder, "50/100", Color.Yellow)
        PopUpButton(R.drawable.placeholder, "20/100", Color.Red)
        PopUpButton(R.drawable.placeholder, "1/100", Color.Red)
    }
}

@Composable
fun PopUpButton(imageId: Int, statValue: String, borderState: Color) {
    val openDialog = remember { mutableStateOf(false) }

    Row() {
        Button(
            onClick = {openDialog.value = !openDialog.value},
            Modifier
                .width(70.dp)
                .height(70.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(Color.White),
            border = BorderStroke(4.dp, borderState),
        ) {
            Image(
                painterResource(imageId),
                "needs_icon",
                Modifier
                    .scale(1.5f)
            )
        }
        Box () {
            val popupWidth = 70.dp
            val popupHeight = 50.dp

            Popup(
                alignment = Alignment.TopCenter,
            ) {
                Box(
                    Modifier
                        .size(popupWidth, popupHeight)
                        .padding(top = 10.dp)
                        .background(Color.White, RoundedCornerShape(10.dp))
                        .border(1.dp, color = Color.Black, RoundedCornerShape(10.dp))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = statValue,
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewHome() {
    HomeScreen {}
}


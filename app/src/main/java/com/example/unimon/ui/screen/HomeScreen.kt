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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview

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
            modifier = Modifier.size(45.dp),
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
        NeedsIcon(R.drawable.placeholder)
        NeedsIcon(R.drawable.placeholder)
        NeedsIcon(R.drawable.placeholder)
        NeedsIcon(R.drawable.placeholder)
    }
}

@Composable
fun NeedsIcon(imageId: Int) {
    Row() {
        Button(
            onClick = {},
            Modifier
                .width(70.dp)
                .height(70.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(Color.White),
            border = BorderStroke(4.dp, Color.Green)
        ) {
            Image(
                painterResource(imageId),
                "needs_icon",
                Modifier
                    .scale(1.5f)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewHome() {
    HomeScreen {}
}


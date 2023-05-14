package com.example.unimon.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unimon.R
import androidx.compose.ui.text.TextStyle

@Preview
@Composable
fun Menu(
//    navigateToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Steps()
        Settings()
    }
    FloatingActionButton(
        onClick = { /*navigateToHomeScreen*/ },
        modifier = Modifier
            .padding(15.dp)
            .size(60.dp, 60.dp),
        shape = CircleShape,
        containerColor = Color.White,
        contentColor = Color.Black,
        elevation = FloatingActionButtonDefaults.elevation()
    ) {
        Icon(
            Icons.Outlined.Menu,
            modifier = Modifier.size(35.dp),
            contentDescription = "Menu_Button"
        )
    }
}

@Composable
fun Steps() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
    Text(
        "Schritte: ",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier
            .align(Alignment.Start)
            .padding(20.dp)
    )
}
}

@Composable
fun Settings() {
    Row(
        Modifier
            .fillMaxHeight()
            .padding(40.dp),
        Arrangement.SpaceEvenly
    ) {
        MenuPoint(R.drawable.placeholder, "Light on/off havlfigipeapfbkesgae")
        MenuPoint(R.drawable.placeholder, "Meet")
        MenuPoint(R.drawable.placeholder, "Study")
    }
}

@Composable
fun MenuPoint(imageId : Int, underlineText : String) {
    Column() {
        Surface(modifier = Modifier.size(50.dp,50.dp)) {
            Image(
                painterResource(imageId),
                "menu_point",
                modifier = Modifier.scale(2f)
                )
        }
        Text(
            text = underlineText,
            fontSize = 20.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Clip,
            style = TextStyle(lineBreak = LineBreak.Simple)
        )
    }
}

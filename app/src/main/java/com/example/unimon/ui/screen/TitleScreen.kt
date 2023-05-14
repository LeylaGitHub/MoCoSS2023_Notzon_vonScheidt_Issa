package com.example.unimon.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unimon.R



val imageModifier = Modifier.size(300.dp)

val ColumnModifier = Modifier
    .padding(15.dp)
    .fillMaxSize()

val ButtonModifier = Modifier
    .size(250.dp, 80.dp)


@Composable
fun TitleScreen(
    navigateToHome: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = ColumnModifier,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Unimon",
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )

        Image(
            painter = painterResource(id = R.drawable.unimon_egg),
            contentDescription = "Unimon_Titlescreen",
            modifier = imageModifier
        )

        Box(modifier = Modifier.padding(0.dp, 50.dp)) {
            Button(
                onClick = navigateToHome,
                modifier = ButtonModifier,
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Click me !",
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewTitle() {
    TitleScreen {}
}
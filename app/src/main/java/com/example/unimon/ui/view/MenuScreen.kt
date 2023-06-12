package com.example.unimon.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unimon.R
import androidx.compose.ui.text.TextStyle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unimon.ui.view_model.UnimonViewModel


@Composable
fun MenuScreen(
    navigateToHome: () -> Unit,
    viewModel: UnimonViewModel = viewModel()
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(R.drawable.menu), contentScale = ContentScale.FillBounds)
        .padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {
        Steps()
        Actions(navigateToHome) { viewModel.changeBackground(buttonState = true) }

        Box(modifier = Modifier
            .weight(1f)
            .fillMaxSize()
        ){
            Box(modifier = Modifier.align(Alignment.BottomEnd)) {
                HomeButton(navigateToHome)
            }
        }
    }
}

@Composable
fun Steps() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp, 20.dp, 100.dp)
            .background(Color.White.copy(alpha = 0.85f), RoundedCornerShape(20.dp))
    ) {
    Text(
        "Schritte: ",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier
            .align(Alignment.Start)
            .padding(15.dp)
    )
}
}

@Composable
fun Actions(navigateToHome: () -> Unit, action:  () -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp),
        Arrangement.Center
    ) {
        MenuPoint(R.drawable.light, "Light on/off", navigateToHome, action)
        MenuPoint(R.drawable.meet, "Meet", navigateToHome, action)
        MenuPoint(R.drawable.study, "Study", navigateToHome, action)
    }
}

@Composable
fun MenuPoint(imageId: Int, underlineText: String, navigateToHome: () -> Unit, action: () -> Unit) {
//    var buttonState by rememberSaveable {(mutableStateOf(false))}
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {navigateToHome(); action()},
            modifier = Modifier
                .size(90.dp,90.dp)
                .border(3.dp, Color.Black, RoundedCornerShape(17.dp))
//                .clickable { navigateToHome() }
                .padding(0.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(20.dp)
        )
        {
            Image(
                painterResource(imageId),
                "placeholder",
                Modifier
                    .size(90.dp)
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

@Composable
fun HomeButton(
    navigateToHome: () -> Unit
){
    FloatingActionButton(
        onClick = navigateToHome,
        modifier = Modifier
            .padding(15.dp)
            .size(70.dp, 70.dp),
        shape = CircleShape,
        containerColor = Color.White,
        contentColor = Color.Black,
        elevation = FloatingActionButtonDefaults.elevation()
    ) {
        Image(
            painterResource(R.drawable.zur_ckpfeil),
            modifier = Modifier.size(50.dp),
            contentDescription = "Menu_Button"
        )
    }
}

//@Preview
//@Composable
//fun DefaultPreviewMenu() {
//    MenuScreen {}
//}

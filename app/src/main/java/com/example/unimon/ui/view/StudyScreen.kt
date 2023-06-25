package com.example.unimon.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unimon.R
import com.example.unimon.ui.view_model.QuestionViewModel

@Composable
fun StudyScreen(
    navigateToMenu: () -> Unit,
    navigateToQuiz: (category: String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(R.drawable.unimon_study), contentScale = ContentScale.FillBounds)
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
    ) {
        CategoryText()
        CategoryList(navigateToQuiz)
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Box(modifier = Modifier.align(Alignment.BottomEnd)) {
                HomeButton(navigateToMenu)
            }
        }
    }
}

@Composable
fun CategoryText() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(30.dp, 0.dp, 30.dp, 100.dp)
            .background(Color.Black.copy(alpha = 0.70f), RoundedCornerShape(20.dp))
            .border(4.dp, Color.Black, RoundedCornerShape(17.dp))
    ) {
        Text(
            "Wähle ein Fach zum Lernen aus!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(25.dp)
        )
    }
}

@Composable
fun CategoryList(navigateToQuiz: (category: String) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp),
        Arrangement.Center
    ) {
        Category(name = "Mathe") { navigateToQuiz("Mathe") }
        Category(name = "Softwaretechnik") { navigateToQuiz("Softwaretechnik") }
        Category(name = "Mobile Computing") { navigateToQuiz("Mobile Computing") }
    }
}


@Composable
fun Category(
    name: String,
    navigateToQuiz: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = navigateToQuiz,
            modifier = Modifier
                .fillMaxWidth()
                .border(4.dp, Color.Black, RoundedCornerShape(17.dp))
                .clickable(onClick = navigateToQuiz)
                .padding(5.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                "$name",
                fontSize = 30.sp,
                color = Color.Black
            )
        }
    }

}
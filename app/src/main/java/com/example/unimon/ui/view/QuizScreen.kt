package com.example.unimon.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unimon.R

@Composable
fun QuizScreen(
    navigateToStudy: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(R.drawable.unimon_quiz), contentScale = ContentScale.FillBounds)
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
    ) {
        Question()
        AnswerList()
        Spacer(modifier = Modifier.weight(1f))
        BottomNavigation(navigateToStudy)
    }
}

@Composable
fun Question() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(30.dp, 0.dp, 30.dp, 100.dp)
            .background(Color.Black, RoundedCornerShape(20.dp))
            .border(4.dp, Color.Black, RoundedCornerShape(17.dp))
    ) {
        Text(
            "Was ist die Anwort auf diese Frage?",
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
fun AnswerList() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp),
        Arrangement.Center
    ) {
        Answer(name = "Antwort A")
        Answer(name = "Antwort B")
        Answer(name = "Antwort C")
    }
}


@Composable
fun Answer(
    name: String
) {
    Column(
        Modifier
            //.background(Color.White)
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .border(4.dp, Color.Black, RoundedCornerShape(20.dp)),
                //.clickable(onClick = navigateToQuiz)
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

@Composable
fun BottomNavigation(
    navigateToStudy: () -> Unit
){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        Arrangement.SpaceEvenly,
        Alignment.Bottom
    ) {
        NavigationButton("Back", navigateToStudy)
        NavigationButton("Next", navigateToStudy)
    }
}

@Composable
fun NavigationButton(
    name: String,
    navigateToStudy: () -> Unit
){
    Row {
        Button(
            onClick = navigateToStudy,
            modifier = Modifier
                .width(140.dp)
                .height(70.dp)
                .border(4.dp, Color.Black, RoundedCornerShape(20.dp)),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                "$name",
                color = Color.White,
                fontSize = 30.sp
            )
        }
    }
}


@Preview
@Composable
fun DefaultPreviewQuiz() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(R.drawable.menu), contentScale = ContentScale.FillBounds)
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(R.drawable.unimon_quiz),
                    contentScale = ContentScale.FillBounds
                )
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {
            Question()
            AnswerList()
            Spacer(modifier = Modifier.weight(1f))
            BottomNavigation({})
        }
    }
}
package com.example.unimon.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.unimon.R

@Composable
fun QuizScreen(
    navigateToStudy: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(R.drawable.unimon_quiz), contentScale = ContentScale.FillBounds)
        .padding(0.dp, 20.dp, 0.dp, 0.dp)
    ) {
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxSize()
        ){
            Box(modifier = Modifier.align(Alignment.BottomEnd)) {
                HomeButton(navigateToStudy)
            }
        }
    }
}
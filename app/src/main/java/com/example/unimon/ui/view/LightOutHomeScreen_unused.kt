package com.example.unimon.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unimon.R
import com.example.unimon.ui.UnimonViewModel

@Composable
fun LightOutHomeScreen(
    navigateToMenu: () -> Unit,
    viewModel: UnimonViewModel = viewModel()
) {
    val unimon by viewModel.unimon.observeAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Stats("SleepyBee", 1)
        Box(modifier = Modifier.weight(1f)) {
            ImageContainer(
                homeBackground = R.drawable.unimon___nightsky,
                homeBackgroundContentD = "unimon_background_nightsky",
                unimonVersion = R.drawable.unimon_schlaf,
                unimonVersionContentD = "unimon_schlaf"
            )
            Box(modifier = Modifier.align(Alignment.BottomEnd)) {
                MenuButton(navigateToMenu)
            }
        }
            BottomRow(unimon!!)
    }
}
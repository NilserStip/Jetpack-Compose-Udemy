package com.nllamo.jetpackcomposefrom0.old.practice.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppProgress() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Cyan)
        Spacer(Modifier.height(12.dp))
        LinearProgressIndicator(color = Color.Magenta, trackColor = Color.Gray)
    }
}

@Composable
fun AppProgressState() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var showLoading by rememberSaveable { mutableStateOf(false) }

        if (showLoading)
            CircularProgressIndicator(color = Color.Cyan)

        Spacer(Modifier.height(12.dp))

        Button(onClick = { showLoading = !showLoading })
        {
            Text(text = "Cambiar de estado")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppProgressAdvance() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var progress by rememberSaveable { mutableFloatStateOf(0f) }

        LinearProgressIndicator(
            progress = { progress },
            color = Color.Magenta,
            trackColor = Color.Gray,
        )

        Spacer(Modifier.height(12.dp))

        Row {
            Button(onClick = {
                if (progress <= 1)
                    progress += 0.1f
            }) {
                Text(text = "Incrementar")
            }

            Spacer(Modifier.width(6.dp))

            Button(onClick = {
                if (progress >= 0)
                    progress -= 0.1f
            }) {
                Text(text = "Reducir")
            }
        }
    }
}
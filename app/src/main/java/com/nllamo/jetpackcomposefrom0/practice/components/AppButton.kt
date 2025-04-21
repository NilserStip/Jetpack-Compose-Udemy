package com.nllamo.jetpackcomposefrom0.practice.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    text: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var enabled by rememberSaveable { mutableStateOf(true) }

        Button(
            onClick = {
                enabled = false
            },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.Cyan,
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.Gray
            ),
            border = BorderStroke(4.dp, Color.LightGray)
        ) {
            Text(text = text)
        }
    }
}
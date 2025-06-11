package com.nllamo.jetpackcomposefrom0.new.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AppButtons() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 48.dp, horizontal = 16.dp),
    ) {
        OutlinedButton(
            onClick = {},
        ) {
            Text(text = "OutlinedButton")
        }

        ElevatedButton(
            onClick = {},
        ) {
            Text(text = "ElevatedButton")
        }

        FilledTonalButton(
            onClick = {},
        ) {
            Text(text = "FilledTonalButton")
        }

        Button(
            onClick = {},
        ) {
            Text(text = "Button")
        }

        TextButton(
            onClick = {},
        ) {
            Text(text = "TextButton")
        }

    }

}
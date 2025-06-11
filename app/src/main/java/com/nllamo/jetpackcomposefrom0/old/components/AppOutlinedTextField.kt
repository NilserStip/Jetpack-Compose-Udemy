package com.nllamo.jetpackcomposefrom0.old.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppOutlinedTextField(
    name: String,
    onValueChanged: (String) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {


        OutlinedTextField(
            value = name,
            onValueChange = { onValueChanged(it) },
            modifier = Modifier.padding(16.dp),
            label = { Text("Ingresa tu nombre") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Red,
                unfocusedBorderColor = Color.Blue
            )
        )
    }
}

@Preview
@Composable
fun AppOutlinedTextFieldPreview() {
    AppOutlinedTextField(
        "Nombre",
    ) {

    }
}
package com.nllamo.jetpackcomposefrom0.old.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AppTextField() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var myText by remember { mutableStateOf("") }

        TextField(
            value = myText,
            onValueChange = { myText = it },
            label = { Text("Ingresa tu nombre") }
        )

    }
}

@Composable
fun AppTextFieldPassword(
    value: String,
    onValueChange: (String) -> Unit,
) {
    var hiddenPassword by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = {
            Text("Introduce tu contraseña")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (hiddenPassword) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Icon(
                imageVector = Icons.Rounded.Visibility,
                contentDescription = "Password",
                modifier = Modifier.clickable{
                    hiddenPassword = !hiddenPassword
                }
            )
        }
    )
}
package com.nllamo.jetpackcomposefrom0.old.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppRadioButton(
    onClick: () -> Unit,
    selected: Boolean,
    text: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            enabled = false,
            onClick = onClick,
            colors = RadioButtonColors(
                selectedColor = Color.Red,
                disabledSelectedColor = Color.Gray,
                unselectedColor = Color.Red,
                disabledUnselectedColor = Color.Gray
            )
        )

        Text(text = text)
    }
}

@Composable
fun AppRadioButtonList() {
    var selected by remember { mutableStateOf("Option 1") }

    Column(modifier = Modifier.fillMaxWidth()) {
        AppRadioButton(
            onClick = { selected = "Option 1" },
            selected = selected == "Option 1",
            text = "Option 1"
        )
        AppRadioButton(
            onClick = { selected = "Option 2" },
            selected = selected == "Option 2",
            text = "Option 2"
        )
        AppRadioButton(
            onClick = { selected = "Option 3" },
            selected = selected == "Option 3",
            text = "Option 3"
        )
        AppRadioButton(
            onClick = { selected = "Option 4" },
            selected = selected == "Option 4",
            text = "Option 4"
        )
    }
}

@Composable
fun AppRadioButtonList(
    name: String,
    onItemSelected: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        AppRadioButton(
            onClick = { onItemSelected("Option 1") },
            selected = name == "Option 1",
            text = "Option 1"
        )
        AppRadioButton(
            onClick = {onItemSelected("Option 2") },
            selected = name == "Option 2",
            text = "Option 2"
        )
        AppRadioButton(
            onClick = { onItemSelected("Option 3") },
            selected = name == "Option 3",
            text = "Option 3"
        )
        AppRadioButton(
            onClick = { onItemSelected("Option 4") },
            selected = name == "Option 4",
            text = "Option 4"
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppRadioButtonPreview() {
    AppRadioButtonList()
}
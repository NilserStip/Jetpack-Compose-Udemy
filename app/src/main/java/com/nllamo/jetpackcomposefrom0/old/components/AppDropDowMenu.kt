package com.nllamo.jetpackcomposefrom0.old.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppDropDowMenu() {

    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("A", "B", "C", "D", "E", "F")

    Column {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {
                selectedText = it
                expanded = true
            },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )
        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach {
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = it
                }, text = { Text(text = it) })
            }
        }
    }
}

@Preview
@Composable
fun AppDropDowMenuPreview() {
    AppDropDowMenu()
}
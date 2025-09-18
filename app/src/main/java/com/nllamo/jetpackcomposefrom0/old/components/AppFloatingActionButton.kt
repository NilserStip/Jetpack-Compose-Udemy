package com.nllamo.jetpackcomposefrom0.old.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun AppFloatingActionButton(
) {
    FloatingActionButton(
        onClick = { },
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}
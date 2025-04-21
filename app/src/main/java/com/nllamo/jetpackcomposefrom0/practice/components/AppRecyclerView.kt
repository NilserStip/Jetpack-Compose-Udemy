package com.nllamo.jetpackcomposefrom0.practice.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AppRecyclerViewManualSingle() {
    LazyColumn {
        item {
            Text(text = "1er elemento")
            Text(text = "2do elemento")
            Text(text = "3er elemento")
        }
    }
}

@Composable
fun AppRecyclerViewManualPlural() {
    LazyColumn {
        items(30) { index ->
            Text(text = "Elemento $index")
        }
    }
}

@Composable
fun AppRecyclerViewManualPluralV2() {
    val myList = listOf("Elemento 1", "Elemento 2", "Elemento 3")
    LazyColumn {
        items(myList) {
            Text(text = "Este es el $it")
        }
    }
}
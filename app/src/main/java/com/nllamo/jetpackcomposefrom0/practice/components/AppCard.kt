package com.nllamo.jetpackcomposefrom0.practice.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(width = 2.dp, color = Color.Red)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Title")
            Text(text = "Title")
            Text(text = "Title")
        }
    }
}

@Preview
@Composable
fun AppCardPreview() {
    AppCard()
}
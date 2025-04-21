package com.nllamo.jetpackcomposefrom0.practice.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppDivider() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .padding(vertical = 12.dp),
        thickness = 2.dp,
        color = Color.LightGray
    )
}

@Preview(showSystemUi = true)
@Composable
fun AppDividerPreview() {
    AppDivider()
}
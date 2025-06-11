package com.nllamo.jetpackcomposefrom0.old.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun AppBadgeBox() {
    BadgedBox(
        badge = {
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .background(Color.Cyan, shape = CircleShape)
            ) {
                Text(
                    text = "1",
                    fontSize = TextUnit(10f, TextUnitType.Sp),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        modifier = Modifier.padding(12.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Favorite"
        )
    }
}

@Preview
@Composable
fun AppBadgeBoxPreview() {
    AppBadgeBox()
}
package com.nllamo.jetpackcomposefrom0.old.practice.components.customize

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppOptions(
    options: List<Options>
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Card(
            modifier = Modifier
                .height(44.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(5.dp),
        ) {
            Row(
                modifier = Modifier.background(Color.White),
                horizontalArrangement = Arrangement.Center
            ) {
                options.forEach {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(all = 4.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (it.active) Color.Green else Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = it.title,
                            color = if (it.active) Color.White else Color.Green
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppOptionsPreview() {
    AppOptions(
        listOf(
            Options(0, "Option 1", true),
            Options(1, "Option 2", false),
        )
    )
}
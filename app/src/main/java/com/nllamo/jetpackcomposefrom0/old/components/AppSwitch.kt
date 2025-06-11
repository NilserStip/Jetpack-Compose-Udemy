package com.nllamo.jetpackcomposefrom0.old.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun AppSwitch() {

    var myState by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = myState,
            onCheckedChange = {
                myState = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Cyan,
                uncheckedThumbColor = Color.DarkGray,
                uncheckedTrackColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { myState = !myState }) {
            Text(text = "Cambiar de estado")
        }
    }
}
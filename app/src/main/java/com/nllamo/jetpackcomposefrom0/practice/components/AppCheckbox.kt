package com.nllamo.jetpackcomposefrom0.practice.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nllamo.jetpackcomposefrom0.practice.model.CheckInfo

@Composable
fun AppCheckbox() {

    var myState by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Checkbox(
            checked = myState,
            onCheckedChange = {
                myState = !myState
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.DarkGray,
                checkmarkColor = Color.Black,
            )
        )
    }
}

@Composable
fun AppCheckboxAdvanced() {
    var myState by rememberSaveable { mutableStateOf(true) }

    Row(
        modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = myState,
            onCheckedChange = {
                myState = !myState
            }
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(text = "Checkbox")
    }
}

@Composable
fun AppCheckboxAdvanced(
    checkInfo: CheckInfo,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = {
                onCheckedChange(it)
//                checkInfo.onCheckedChange(!checkInfo.selected)
            }
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(text = checkInfo.title)
    }
}

@Composable
fun AppTriStateCheckbox(
    toggleableState: (ToggleableState) -> Unit,
) {

    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = status, onClick = {
        when (status) {
            ToggleableState.On -> {
                toggleableState(ToggleableState.Off)
                status = ToggleableState.Off
            }
            ToggleableState.Off -> {
                toggleableState(ToggleableState.Indeterminate)
                status = ToggleableState.Indeterminate
            }
            ToggleableState.Indeterminate -> {
                toggleableState(ToggleableState.On)
                status = ToggleableState.On
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun AppCheckboxAdvancedPreview() {

//    Column {
//        AppTriStateCheckbox() {}
//        AppCheckboxAdvanced(
//            checkInfo = CheckInfo(
//                title = "Checkbox",
//                selected = true,
//                onCheckedChange = {}
//            )
//        )
//    }
}
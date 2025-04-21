package com.nllamo.jetpackcomposefrom0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import com.nllamo.jetpackcomposefrom0.practice.components.AppOutlinedTextField
import com.nllamo.jetpackcomposefrom0.practice.model.CheckInfo
import com.nllamo.jetpackcomposefrom0.projects.superhero.SuperHeroScreen
import com.nllamo.jetpackcomposefrom0.ui.theme.JetpackComposeFrom0Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeFrom0Theme {
                SuperHeroScreen()

//                TuitsScreen()

//                LoginScreen()

//               showAppAlertDialog()

//                AppOptions(
//                    listOf(
//                        Options(0, "Option 1", true),
//                        Options(1, "Option 2", false),
//                    )
//                )

//                Greeting()
//                Column(
//                    modifier = Modifier.padding(top = 48.dp)
//                ) {
//
//                    var statusGeneral by rememberSaveable {
//                        mutableStateOf(ToggleableState.Off)
//                    }
//
//                    AppTriStateCheckbox() {
//                        statusGeneral = it
//                    }
//
//                    val myOptions =
//                        getOptions(statusGeneral = statusGeneral, listOf("Red", "Green", "Blue"))
//                    myOptions.forEach {
//                        AppCheckboxAdvanced(
//                            it
//                        ) { isChecked ->
//                             if (!isChecked) statusGeneral = ToggleableState.Off
//                        }
//                    }
//                }
            }
        }
    }
}

@Composable
fun getOptions(
    statusGeneral: ToggleableState,
    titles: List<String>,
): List<CheckInfo> {

    return titles.map {

        var status by rememberSaveable {
            mutableStateOf(false)
        }

        if (statusGeneral == ToggleableState.On)
            status = true

        CheckInfo(
            title = it,
            selected = statusGeneral == ToggleableState.On || status,
            onCheckedChange = { newStatus ->
                status = newStatus
            })
    }
}

@Composable
fun Greeting() {
    var myText by remember { mutableStateOf("") }

    AppOutlinedTextField(myText) {
        myText = it
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeFrom0Theme {
        Greeting()
    }
}
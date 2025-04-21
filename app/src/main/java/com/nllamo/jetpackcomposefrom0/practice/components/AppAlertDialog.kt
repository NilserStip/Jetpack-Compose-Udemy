package com.nllamo.jetpackcomposefrom0.practice.components

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.nllamo.jetpackcomposefrom0.R

@Composable
fun showAppAlertDialog() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var show by remember { mutableStateOf(false) }

        Button(
            onClick = {
                show = true
            }
        ) {
            Text("Mostrar Dialog")
        }
        AppAlertDialogItemList(
            show = show,
            onDismiss = {
                show = false
            },
            onConfirm = {
                Log.d("JetpackComposeFrom0", "Confirmado")
                show = false
            }
        )
    }
}

@Composable
fun AppAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (!show) return

    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text("Title")
        },
        text = {
            Text("Message")
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@Composable
fun AppAlertDialogCustom(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    if (!show) return

    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            AppMyTitleDialog("Actualiza la versión de la App")

            Spacer(modifier = Modifier.padding(8.dp))

            TextButton(
                modifier = Modifier.align(Alignment.End),
                onClick = {
                    onConfirm()
                }
            ) {
                Text(text = "Actualizar", color = Color.Blue)
            }
        }
    }
}

@Composable
fun AppAlertDialogAccountList(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    if (!show) return

    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            AppMyTitleDialog(text = "Selecciona una cuenta")

            Spacer(modifier = Modifier.padding(8.dp))

            AccountItemDialog(
                drawable = R.drawable.avatar,
                description = "example1@gmail.com"
            )
            AccountItemDialog(
                drawable = R.drawable.avatar,
                description = "example2@gmail.com"
            )
            AccountItemDialog(
                drawable = R.drawable.add,
                description = "Añadir nueva cuenta"
            )
        }
    }
}

@Composable
fun AppMyTitleDialog(
    text: String
) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier.padding(4.dp)
    )
}

@Composable
fun AccountItemDialog(
    @DrawableRes drawable: Int,
    description: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = description,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun AppAlertDialogItemList(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    if (!show) return

    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            AppMyTitleDialog(text = "Selecciona una opción")
            HorizontalDivider(
                modifier = Modifier.padding(8.dp)
            )
            var status by remember { mutableStateOf("") }
            AppRadioButtonList(status) {
                status = it
            }
            HorizontalDivider(
                modifier = Modifier.padding(8.dp)
            )

            Row(
                modifier = Modifier.align(Alignment.End)
            ) {
                TextButton(onClick = {}) {
                    Text(text = "Cancelar", color = Color.Gray)
                }
                TextButton(onClick = {}) {
                    Text(text = "Ok", color = Color.Gray)
                }
            }
        }
    }
}

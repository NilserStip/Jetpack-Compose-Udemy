package com.nllamo.jetpackcomposefrom0.old.projects.instagram

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nllamo.jetpackcomposefrom0.R

const val MIN_CHARACTERS_PASSWORD = 6

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Header(
    modifier: Modifier
) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close",
        modifier = modifier
            .size(28.dp)
            .clickable {
                activity.finish()
            })
}

@Composable
fun Body(
    modifier: Modifier
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnabled by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        ImageLogo(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.size(16.dp))

        InputEmail(
            email = email
        ) {
            email = it
            isLoginEnabled = enabledLogin(email, password)
        }

        Spacer(modifier = Modifier.size(4.dp))

        InputPassword(
            password = password
        ) {
            password = it
            isLoginEnabled = enabledLogin(email, password)
        }

        Spacer(modifier = Modifier.size(8.dp))

        ForgotPassword(
            modifier = Modifier.align(Alignment.End),
            onAction = {}
        )

        Spacer(modifier = Modifier.size(16.dp))

        ButtonLogin(
            isLoginEnabled = isLoginEnabled
        )

        Spacer(modifier = Modifier.size(16.dp))

        LoginDivider()

        Spacer(modifier = Modifier.size(32.dp))

        SocialLogin()
    }
}


@Composable
fun Footer(
    modifier: Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
        )
        SignUp()
    }
}

@Composable
fun SignUp() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Don't have an account?",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = "Sign Up.",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Instagram",
    )
}

@Composable
fun InputEmail(
    email: String,
    function: (String) -> Unit
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        onValueChange = { function(it) },
        maxLines = 1,
        singleLine = true,
        placeholder = { Text(text = "Phone number, username or email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black,
        )
    )
}

@Composable
fun InputPassword(
    password: String,
    function: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = { function(it) },
        maxLines = 1,
        singleLine = true,
        placeholder = { Text(text = "Password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black,
        ),
        trailingIcon = {
            val image = if (passwordVisibility)
                Icons.Filled.VisibilityOff
            else
                Icons.Filled.Visibility

            IconButton(
                onClick = {
                    passwordVisibility = !passwordVisibility
                }
            ) {
                Icon(
                    imageVector = image,
                    contentDescription = "Visibility",
                )
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun ForgotPassword(
    modifier: Modifier,
    onAction: () -> Unit,
) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier.clickable {
            onAction()
        },
    )
}

@Composable
fun ButtonLogin(
    isLoginEnabled: Boolean,
) {
    Button(
        onClick = {},
        enabled = isLoginEnabled,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonColors(
            containerColor = Color(0xFF4EA8E9),
            contentColor = Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = Color(0xFF78C8F9),
        )
    ) {
        Text(text = "Log In")
    }
}

fun enabledLogin(
    email: String,
    password: String
): Boolean {
    return email.isNotEmpty() &&
            Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
            password.isNotEmpty() &&
            password.length >= MIN_CHARACTERS_PASSWORD
}

@Composable
fun LoginDivider() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .height(1.dp)
                .background(Color(0xFFF9F9F9))
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 6.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        HorizontalDivider(
            modifier = Modifier
                .height(1.dp)
                .background(Color(0xFFF9F9F9))
                .weight(1f)
        )
    }
}

@Composable
fun SocialLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Facebook",
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "Continue as Nilser Llamo",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF385185)
        )
    }
}
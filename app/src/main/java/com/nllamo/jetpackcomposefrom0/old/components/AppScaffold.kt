package com.nllamo.jetpackcomposefrom0.old.components

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppScaffold() {
    Scaffold(
        topBar = {
            AppTopBar()
        },
        content = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    TopAppBar(
        title = {
            Text(text = "App Title", color = Color.Red)
        },
    )
}
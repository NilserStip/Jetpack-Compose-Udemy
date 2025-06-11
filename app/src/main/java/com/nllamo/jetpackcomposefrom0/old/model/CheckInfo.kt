package com.nllamo.jetpackcomposefrom0.old.model

data class CheckInfo(

    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit

)

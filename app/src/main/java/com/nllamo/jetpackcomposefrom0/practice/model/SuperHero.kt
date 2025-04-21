package com.nllamo.jetpackcomposefrom0.practice.model

import androidx.annotation.DrawableRes

data class SuperHero(
    val alias: String,
    val name: String,
    val publisher: String,
    @DrawableRes val photo: Int,
)

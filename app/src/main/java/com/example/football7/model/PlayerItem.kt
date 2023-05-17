package com.example.football7.model

import androidx.annotation.Keep

@Keep
data class PlayerItem(
    val image:String,
    val name:String,
    val club:String
)
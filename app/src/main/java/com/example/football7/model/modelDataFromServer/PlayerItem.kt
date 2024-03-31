package com.example.football7.model.modelDataFromServer

import androidx.annotation.Keep

@Keep
data class PlayerItem(
    val image:String,
    val name:String,
    val club:String
)
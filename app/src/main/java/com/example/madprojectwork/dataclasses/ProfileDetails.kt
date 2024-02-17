package com.example.madprojectwork.dataclasses

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class ProfileDetails(
    val name: String,
    val email: String,
    var phone: MutableState<String> = mutableStateOf(""),
    val address: String,
    var password: MutableState<String> = mutableStateOf("")
)
val profileList = listOf(
    ProfileDetails(
        name = "V. Karthik",
        email = "goomba69@gmail.com",
        address = "123, 4th cross, 5th main, Bangalore"
    )
)
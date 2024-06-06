package com.example.fitfusion

import java.io.Serializable

data class User(
    var name: String = "",
    var gender: String = "",
    var age: Int = 0,
    var height: Int = 0,
    var weight: Int = 0,
    var targetWeight: Int = 0,
    var bmi: Double = 0.0,
    var email: String = ""
) : Serializable

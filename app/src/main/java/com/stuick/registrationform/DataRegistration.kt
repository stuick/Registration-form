package com.stuick.registrationform

import java.io.Serializable

data class DataRegistration(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val jobTitle: String
) : Serializable{
}
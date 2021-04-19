package com.cristian.pam1.data.model

data class AuthBody(
    private val grant_type:String = "password",
    private val username: String,
    private val password: String
)

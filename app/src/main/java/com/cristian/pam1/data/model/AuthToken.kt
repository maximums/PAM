package com.cristian.pam1.data.model

import com.google.gson.annotations.SerializedName

data class AuthToken(
    @SerializedName("access_token")
    val access_token: String,
    @SerializedName("token_type")
    val token_type: String,
    @SerializedName("expires_in")
    val expires_in: String,
    @SerializedName("refresh_token")
    val refresh_token: String,
    @SerializedName("scope")
    val scope: String,
    @SerializedName("created_at")
    val created_at: String
)

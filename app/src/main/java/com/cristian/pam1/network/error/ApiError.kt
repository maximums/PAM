package com.cristian.pam1.network.error

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("status")
    val statusCode: Int? = null,
    @SerializedName("message")
    val clientErrorMessage: String? = null,
    @SerializedName("error")
    val error: String? = null
)
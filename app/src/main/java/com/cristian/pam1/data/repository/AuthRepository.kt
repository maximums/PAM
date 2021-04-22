package com.cristian.pam1.data.repository

import com.cristian.pam1.data.api.ApiService
import com.cristian.pam1.data.model.AuthToken
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthRepository {

    private val BASE_URL: String = "https://kitsu.io/api/"

    private val service: ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun auth(credentials: AuthToken.AuthBody) : AuthToken = service.auth(credentials)

    suspend fun refreshToken(currentTokBody: AuthToken.RefreshTokBody): AuthToken = service.refreshToken(currentTokBody)
}
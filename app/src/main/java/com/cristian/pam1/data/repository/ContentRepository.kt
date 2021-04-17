package com.cristian.pam1.data.repository

import com.cristian.pam1.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ContentRepository {

    private val BASE_URL: String = "https://kitsu.io/api/edge/"

    private val service: ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun searchContent(category: String) =  service.searchContent(category)

}
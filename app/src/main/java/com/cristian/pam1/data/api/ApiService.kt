package com.cristian.pam1.data.api

import com.cristian.pam1.data.model.APIResponse
import com.cristian.pam1.data.model.AuthBody
import com.cristian.pam1.data.model.AuthToken
import retrofit2.http.Body
import retrofit2.http.GET;
import retrofit2.http.POST
import retrofit2.http.Query;

interface ApiService {
    @GET("anime?page[limit]=20&page[offset]=0&fields[anime]=canonicalTitle,description,posterImage")
    suspend fun searchContent(
        @Query("filter[categories]") query: String?
    ) : APIResponse

    @POST("oauth/token")
    suspend fun auth(@Body body: AuthBody) : AuthToken
}
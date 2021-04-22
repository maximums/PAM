package com.cristian.pam1.data.api

import com.cristian.pam1.data.model.ApiResponse
import com.cristian.pam1.data.model.AuthToken
import retrofit2.http.Body
import retrofit2.http.GET;
import retrofit2.http.POST
import retrofit2.http.Query;

interface ApiService {

    @GET("anime?page[limit]=20&sort=popularityRank")
    suspend fun searchContent(
        @Query("filter[categories]") query: String?
    ) : ApiResponse

    @POST("oauth/token")
    suspend fun auth(@Body body: AuthToken.AuthBody) : AuthToken

    @GET("manga?page[limit]=20&fields[anime]=canonicalTitle,description,posterImage&sort=popularityRank")
    suspend fun searchManga(
        @Query("filter[categories]") query: String?
    ) : ApiResponse

    @POST("oauth/token")
    suspend fun refreshToken(@Body body: AuthToken.RefreshTokBody) : AuthToken

}
package com.cristian.pam1.data.api

import com.cristian.pam1.data.model.APIResponse
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ApiService {
    @GET("anime?page[limit]=20&page[offset]=0&fields[anime]=canonicalTitle,description,posterImage")
    suspend fun searchContent(
        @Query("filter[categories]") query: String?
    ) : APIResponse
}
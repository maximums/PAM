package com.cristian.pam1.network

import com.cristian.pam1.network.error.ApiError
import com.cristian.pam1.network.error.HttpErrorInterceptor
import com.cristian.pam1.network.models.SearchResult
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory

private const val READ_TIMEOUT: Long = 3000
private const val WRITE_TIMEOUT: Long = 3000
private const val CONNECTION_TIMEOUT: Long = 3000

class Communication {
    private val client = buildClient()

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://images-api.nasa.gov/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val service = retrofit.create(Service::class.java)

    private fun buildClient(): OkHttpClient {
        val errorInterceptor = HttpErrorInterceptor {
            retrofit.responseBodyConverter(ApiError::class.java, emptyArray())
        }
        return OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
            .connectionPool(ConnectionPool(20, 5, TimeUnit.MINUTES))
            .addInterceptor(errorInterceptor)
            .build()
    }

    suspend fun search(term: String, query: Map<String, String>? = null): ArrayList<SearchResult> {
        return service.search(term, query)
    }
}
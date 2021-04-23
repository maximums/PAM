package com.cristian.pam1.utils

import com.cristian.pam1.data.api.ApiService
import com.cristian.pam1.data.repository.ContentRepository
import com.cristian.pam1.ui.viewmodel.ContentFragmentViewModel
import com.cristian.pam1.ui.viewmodel.ContentFragmentViewModelFactory
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    single {
        ContentFragmentViewModelFactory(get())
    }
}

val repositoryModule = module {
    single {
        ContentRepository(get())
    }
}

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
    single { provideUseApi(get()) }
}

val retrofitModule = module {

    fun provideGson(): Gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()

    fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://kitsu.io/api/edge/")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}

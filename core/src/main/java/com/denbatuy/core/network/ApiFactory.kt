package com.denbatuy.core.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class ApiFactory {

    companion object {

        private val contentType = "application/json".toMediaType()
        private val json = Json { ignoreUnknownKeys = true }

        private const val BASE_URL = "https://api.nytimes.com/"

        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            level= HttpLoggingInterceptor.Level.BODY
        }

        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor).build()

        private val retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(json.asConverterFactory(contentType))
                .build()

        val apiService: ApiService = retrofit.create(ApiService::class.java)

    }
}
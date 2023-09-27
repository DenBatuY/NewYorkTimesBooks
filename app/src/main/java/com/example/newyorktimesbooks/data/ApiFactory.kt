package com.example.newyorktimesbooks.data

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

    companion object {

        private val contentType = "application/json".toMediaType()
        private val json = Json { ignoreUnknownKeys = true }

        private const val BASE_URL = "https://api.nytimes.com/svc/books/v3/"

        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            level= HttpLoggingInterceptor.Level.BODY
        }

        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor).build()

        private val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                //.addCallAdapterFactory(json.asConverterFactory(contentType))
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val apiService: ApiService = retrofit.create(ApiService::class.java)

    }
}
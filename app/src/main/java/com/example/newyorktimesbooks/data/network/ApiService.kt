package com.example.newyorktimesbooks.data.network

import com.example.newyorktimesbooks.data.network.categories_dto.CategoriesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("lists/names.json")
   // @GET("lists/names.json?api-key=BcYSdg3RZS3v5xsv6570ILLr2R0gaqUD")
    suspend fun loadCategory(
        @Query("api-key") apiKey: String = API_KEY
    ): Response<CategoriesDto>


    companion object {
        private const val API_KEY = "BcYSdg3RZS3v5xsv6570ILLr2R0gaqUD"
    }
}
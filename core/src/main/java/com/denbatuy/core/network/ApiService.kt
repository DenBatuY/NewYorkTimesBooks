package com.denbatuy.core.network

import com.denbatuy.core.network.dto.books.BooksDto
import com.denbatuy.core.network.dto.categories.CategoriesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/svc/books/v3/lists/names.json")
    suspend fun loadCategory(
        @Query("api-key") apiKey: String = API_KEY
    ): Response<CategoriesDto>

    @GET("/svc/books/v3//lists/current/{categoryName}.json")
    suspend fun loadBooksByCategory(
        @Path("categoryName") categoryName: String ,
        @Query("api-key") apiKey: String = API_KEY
    ): Response<BooksDto>


    companion object {
        private const val API_KEY = "BcYSdg3RZS3v5xsv6570ILLr2R0gaqUD"
    }
}
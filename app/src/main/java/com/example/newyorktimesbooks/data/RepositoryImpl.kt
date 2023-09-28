package com.example.newyorktimesbooks.data

import android.util.Log
import com.example.newyorktimesbooks.data.network.ApiService
import com.example.newyorktimesbooks.domain.Repository

class RepositoryImpl(
    private val service: ApiService
) : Repository {
    override suspend fun loadCategories() {
        try {
            val response = service.loadCategory()
            Log.d("myTest", "success ${response.body()}")
        } catch (e: Exception) {
            Log.d("myTest", "load error $e")
        }
    }
}
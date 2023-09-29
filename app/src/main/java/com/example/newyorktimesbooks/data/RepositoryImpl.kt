package com.example.newyorktimesbooks.data

import android.util.Log
import com.denbatuy.core.network.ApiService
import com.example.newyorktimesbooks.domain.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.UnknownHostException

class RepositoryImpl(
    private val service: ApiService,
    private val mapper: Mapper
) : Repository {
    override suspend fun loadCategories() {
        try {
            val response = service.loadCategory()
            if (response.isSuccessful) {
                val entity =
                    response.body()?.resultCategories?.map { mapper.mapCategoriesFromDtoToEntity(it) }
            }
            Log.d("myTest", "load body  ${response.code()}")
        } catch (e: IOException) {
            Log.d("myTest", "load InternetError  $e")
        } catch (e: Exception) {
            Log.d("myTest", "load error $e")
        }
    }


    init {
        MainScope().launch {
            loadBooksByCategory("")
        }
    }

    override suspend fun loadBooksByCategory(category: String) {
        try {
            val response = service.loadBooksByCategory()
            if (response.isSuccessful) {
            }
        } catch (e: IOException) {
            Log.d("myTest", "load InternetError loadBooksByCategory $e")
        } catch (e: Exception) {
            Log.d("myTest", "load error loadBooksByCategory $e")
        }
    }

    companion object {
        private const val STATUS_OK = "OK"
        private const val STATUS_ERROR = "ERROR"
    }
}
package com.example.newyorktimesbooks.domain

interface Repository {
    suspend fun loadCategories()
    suspend fun loadBooksByCategory(category:String)

}
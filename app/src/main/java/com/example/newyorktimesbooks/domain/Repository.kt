package com.example.newyorktimesbooks.domain

import com.example.newyorktimesbooks.domain.entitys.BooksEntity
import com.example.newyorktimesbooks.domain.entitys.CategoriesEntity
import com.example.newyorktimesbooks.domain.entitys.Resource
import kotlinx.coroutines.flow.SharedFlow

interface Repository {
    suspend fun loadCategories()
    fun getCategories():SharedFlow<Resource<List<CategoriesEntity>>>
    suspend fun loadBooks(category:String)
    fun getBooksList():SharedFlow<Resource<List<BooksEntity>>>

}
package com.example.newyorktimesbooks.domain

import com.example.newyorktimesbooks.domain.entitys.BooksEntity
import com.example.newyorktimesbooks.domain.entitys.CategoriesEntity
import com.example.newyorktimesbooks.domain.entitys.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface Repository {
    suspend fun loadCategories()
    fun getCategories(): Flow<List<CategoriesEntity>>
    fun getCategoriesState():SharedFlow<Resource<Unit>>
    suspend fun loadBooks(category:String)
    fun getBooksListState():SharedFlow<Resource<Unit>>
    fun getBooksList(categoryName: String):Flow<List<BooksEntity>>
}
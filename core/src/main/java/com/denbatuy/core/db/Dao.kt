package com.denbatuy.core.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategoriesList(categoriesList: List<CategoryDb>)

    @Query("SELECT*FROM category")
    fun getCategoriesList(): Flow<List<CategoryDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooksList(categoriesList: List<BooksDb>)

    @Query("SELECT*FROM books WHERE categoryName ==:categoryName")
    fun getBooksList(categoryName: String): Flow<List<BooksDb>>


}
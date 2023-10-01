package com.denbatuy.core.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BooksDb(
    @PrimaryKey
    val title: String,
    val categoryName: String,
    val rank: Int,
    val description: String,
    val bookImage: String,
    val buyLinks:String ,
    val author: String,
    val publisher: String,
)
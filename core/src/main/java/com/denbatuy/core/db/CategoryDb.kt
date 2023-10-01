package com.denbatuy.core.db

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "category")
data class CategoryDb(
    @PrimaryKey
    val listName: String,
    val listNameEncoded: String,
    val newestPublishedDate: String,
    val oldestPublishedDate: String,
)

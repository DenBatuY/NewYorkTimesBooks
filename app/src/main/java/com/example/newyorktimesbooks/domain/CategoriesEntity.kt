package com.example.newyorktimesbooks.domain


data class CategoriesEntity(
    val listName: String,
    val listNameEncoded: String,
    val newestPublishedDate: String,
    val oldestPublishedDate: String,
)
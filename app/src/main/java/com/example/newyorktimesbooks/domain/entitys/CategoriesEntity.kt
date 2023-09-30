package com.example.newyorktimesbooks.domain.entitys


data class CategoriesEntity(
    val listName: String,
    val listNameEncoded: String,
    val newestPublishedDate: String,
    val oldestPublishedDate: String,
)
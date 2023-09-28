package com.example.newyorktimesbooks.data.network.categories_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesDto(
    @SerialName("copyright")
    val copyright: String?,
    @SerialName("num_results")
    val numResults: Int?,
    @SerialName("results")
    val results: List<Result>?,
    @SerialName("status")
    val status: String?
)
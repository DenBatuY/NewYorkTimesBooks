package com.denbatuy.core.network.dto.categories


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesDto(
    @SerialName("num_results")
    val numResults: Int?,
    @SerialName("results")
    val resultCategories: List<ResultCategoryDto>?,
    @SerialName("status")
    val status: String?
)
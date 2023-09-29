package com.denbatuy.core.network.dto.categories


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultCategoryDto(
    @SerialName("display_name")
    val displayName: String,
    @SerialName("list_name")
    val listName: String,
    @SerialName("list_name_encoded")
    val listNameEncoded: String,
    @SerialName("newest_published_date")
    val newestPublishedDate: String,
    @SerialName("oldest_published_date")
    val oldestPublishedDate: String,
    @SerialName("updated")
    val updated: String?
)
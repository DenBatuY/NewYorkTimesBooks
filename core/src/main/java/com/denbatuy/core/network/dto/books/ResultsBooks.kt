package com.denbatuy.core.network.dto.books


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultsBooks(
    @SerialName("bestsellers_date")
    val bestsellersDate: String,
    @SerialName("books")
    val booksListDtos: List<BooksListDto>,
    @SerialName("display_name")
    val displayName: String,
    @SerialName("list_name")
    val listName: String,
    @SerialName("list_name_encoded")
    val listNameEncoded: String,
    @SerialName("next_published_date")
    val nextPublishedDate: String,
    @SerialName("normal_list_ends_at")
    val normalListEndsAt: Int,
    @SerialName("previous_published_date")
    val previousPublishedDate: String,
    @SerialName("published_date")
    val publishedDate: String,
    @SerialName("published_date_description")
    val publishedDateDescription: String,
    @SerialName("updated")
    val updated: String
)
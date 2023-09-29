package com.denbatuy.core.network.dto.books


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksDto(
    @SerialName("last_modified")
    val lastModified: String,
    @SerialName("num_results")
    val numResults: Int,
    @SerialName("results")
    val resultsBooks: ResultsBooks,
    @SerialName("status")
    val status: String
)
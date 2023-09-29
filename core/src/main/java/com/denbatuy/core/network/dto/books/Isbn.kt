package com.denbatuy.core.network.dto.books


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Isbn(
    @SerialName("isbn10")
    val isbn10: String,
    @SerialName("isbn13")
    val isbn13: String
)
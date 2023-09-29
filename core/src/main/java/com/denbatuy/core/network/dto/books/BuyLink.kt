package com.denbatuy.core.network.dto.books


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuyLink(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)
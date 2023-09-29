package com.denbatuy.core.network.dto.books


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    @SerialName("age_group")
    val ageGroup: String,
    @SerialName("amazon_product_url")
    val amazonProductUrl: String,
    @SerialName("article_chapter_link")
    val articleChapterLink: String,
    @SerialName("asterisk")
    val asterisk: Int,
    @SerialName("author")
    val author: String,
    @SerialName("book_image")
    val bookImage: String,
    @SerialName("book_image_height")
    val bookImageHeight: Int,
    @SerialName("book_image_width")
    val bookImageWidth: Int,
    @SerialName("book_review_link")
    val bookReviewLink: String,
    @SerialName("book_uri")
    val bookUri: String,
    @SerialName("buy_links")
    val buyLinks: List<BuyLink>,
    @SerialName("contributor")
    val contributor: String,
    @SerialName("contributor_note")
    val contributorNote: String,
    @SerialName("dagger")
    val dagger: Int,
    @SerialName("description")
    val description: String,
    @SerialName("first_chapter_link")
    val firstChapterLink: String,
    @SerialName("isbns")
    val isbns: List<Isbn>,
    @SerialName("price")
    val price: String,
    @SerialName("primary_isbn10")
    val primaryIsbn10: String,
    @SerialName("primary_isbn13")
    val primaryIsbn13: String,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("rank")
    val rank: Int,
    @SerialName("rank_last_week")
    val rankLastWeek: Int,
    @SerialName("sunday_review_link")
    val sundayReviewLink: String,
    @SerialName("title")
    val title: String,
    @SerialName("weeks_on_list")
    val weeksOnList: Int
)
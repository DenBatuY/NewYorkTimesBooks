package com.example.newyorktimesbooks.domain.entitys

data class BooksEntity(
    val categoryName:String,
    val rank:Int,
    val description:String,
    val title:String,
    val book_image:String,
    val buy_links:List<BuyLinkEntity>,
    val author: String,
    val publisher: String,
)

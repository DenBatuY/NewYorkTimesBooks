package com.example.newyorktimesbooks.data

import com.denbatuy.core.network.dto.books.BooksListDto
import com.denbatuy.core.network.dto.categories.ResultCategoryDto
import com.example.newyorktimesbooks.domain.entitys.BooksEntity
import com.example.newyorktimesbooks.domain.entitys.BuyLinkEntity
import com.example.newyorktimesbooks.domain.entitys.CategoriesEntity

class Mapper {
    fun mapCategoriesFromDtoToEntity(dto: ResultCategoryDto): CategoriesEntity {
        return CategoriesEntity(
            listName = dto.listName,
            listNameEncoded = dto.listNameEncoded,
            newestPublishedDate = dto.newestPublishedDate,
            oldestPublishedDate = dto.oldestPublishedDate
        )
    }

    fun mapBookDtoToEntity(categoryName:String, booksListDto: BooksListDto): BooksEntity {
        return BooksEntity(
            categoryName = categoryName,
            rank = booksListDto.rank,
            description = booksListDto.description,
            title = booksListDto.title,
            book_image = booksListDto.bookImage,
            buy_links = booksListDto.buyLinks.map { BuyLinkEntity(name = it.name, url = it.url) },
            author = booksListDto.author,
            publisher = booksListDto.publisher
        )
    }
}
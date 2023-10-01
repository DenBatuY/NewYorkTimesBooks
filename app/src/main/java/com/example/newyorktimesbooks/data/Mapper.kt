package com.example.newyorktimesbooks.data

import com.denbatuy.core.db.BooksDb
import com.denbatuy.core.db.CategoryDb
import com.denbatuy.core.network.dto.books.BooksListDto
import com.denbatuy.core.network.dto.categories.ResultCategoryDto
import com.example.newyorktimesbooks.domain.entitys.BooksEntity
import com.example.newyorktimesbooks.domain.entitys.BuyLinkEntity
import com.example.newyorktimesbooks.domain.entitys.CategoriesEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Mapper(private val gson: Gson) {

    fun mapCategoriesDtoToDb(dto: ResultCategoryDto): CategoryDb {
        return CategoryDb(
            listNameEncoded = dto.listNameEncoded,
            listName = dto.listName,
            newestPublishedDate = dto.newestPublishedDate,
            oldestPublishedDate = dto.oldestPublishedDate
        )
    }

    fun mupCategoriesDbToEntity(db: CategoryDb): CategoriesEntity {
        return CategoriesEntity(
            listName = db.listName,
            listNameEncoded = db.listNameEncoded,
            newestPublishedDate = db.newestPublishedDate,
            oldestPublishedDate = db.oldestPublishedDate
        )
    }

    fun mapBookDtoToDb(categoryName: String, booksListDto: BooksListDto): BooksDb {
        return BooksDb(
            categoryName = categoryName,
            rank = booksListDto.rank,
            description = booksListDto.description,
            title = booksListDto.title,
            bookImage = booksListDto.bookImage,
            buyLinks = gson.toJson(booksListDto.buyLinks),
            author = booksListDto.author,
            publisher = booksListDto.publisher
        )
    }

    private val listType = object : TypeToken<List<BuyLinkEntity>>() {}.type
    fun mapBookDbToEntity(booksDb: BooksDb): BooksEntity {
        return BooksEntity(
            categoryName = booksDb.categoryName,
            rank = booksDb.rank,
            description = booksDb.description,
            title = booksDb.title,
            book_image = booksDb.bookImage,
            buy_links = gson.fromJson(booksDb.buyLinks, listType),
            author = booksDb.author,
            publisher = booksDb.publisher
        )
    }
}
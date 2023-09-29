package com.example.newyorktimesbooks.data

import com.denbatuy.core.network.dto.categories.ResultCategoryDto
import com.example.newyorktimesbooks.domain.CategoriesEntity

class Mapper {
    fun mapCategoriesFromDtoToEntity(dto: ResultCategoryDto): CategoriesEntity {
        return CategoriesEntity(
            listName = dto.listName,
            listNameEncoded = dto.listNameEncoded,
            newestPublishedDate = dto.newestPublishedDate,
            oldestPublishedDate = dto.oldestPublishedDate
        )
    }
}
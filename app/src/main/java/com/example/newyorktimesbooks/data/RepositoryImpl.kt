package com.example.newyorktimesbooks.data

import com.denbatuy.core.network.ApiService
import com.example.newyorktimesbooks.domain.Repository
import com.example.newyorktimesbooks.domain.entitys.BooksEntity
import com.example.newyorktimesbooks.domain.entitys.CategoriesEntity
import com.example.newyorktimesbooks.domain.entitys.Resource
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.io.IOException

class RepositoryImpl(
    private val service: ApiService,
    private val mapper: Mapper
) : Repository {
    private val categoriesState = MutableSharedFlow<Resource<List<CategoriesEntity>>>()
    private val booksState = MutableSharedFlow<Resource<List<BooksEntity>>>()
    override suspend fun loadCategories() {
        categoriesState.emit(Resource.loading())
        try {
            val response = service.loadCategory()
            if (response.isSuccessful) {
                val entity = response.body()?.resultCategories
                    ?.map { mapper.mapCategoriesFromDtoToEntity(it) }
                if (entity != null)
                    categoriesState.emit(Resource.success(entity))
            } else throw Exception(response.message())
        } catch (e: IOException) {
            categoriesState.emit(Resource.internetError())
        } catch (e: Exception) {
            categoriesState.emit(Resource.error(Throwable(e.message)))
        }
    }

    override fun getCategories(): SharedFlow<Resource<List<CategoriesEntity>>> =
        categoriesState.asSharedFlow()


    override suspend fun loadBooks(category: String) {
        try {
            booksState.emit(Resource.loading())
            val response = service.loadBooksByCategory(categoryName = category)
            if (response.isSuccessful) {
                val categoryName = response.body()?.resultsBooks?.listName ?: UNKNOWN_NAME
                val entity = response.body()?.resultsBooks?.booksListDtos?.map {
                    mapper.mapBookDtoToEntity(categoryName, it)
                }
                if (entity != null)
                    booksState.emit(Resource.success(entity))
            } else throw Exception(response.message())
        } catch (e: IOException) {
            booksState.emit(Resource.internetError())
        } catch (e: Exception) {
            booksState.emit(Resource.error(Throwable(e.message)))
        }
    }

    override fun getBooksList(): SharedFlow<Resource<List<BooksEntity>>> =
        booksState.asSharedFlow()

    companion object {
        private const val UNKNOWN_NAME = "Unknown name"
    }
}
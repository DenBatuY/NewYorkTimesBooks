package com.example.newyorktimesbooks.data

import com.denbatuy.core.db.Dao
import com.denbatuy.core.network.ApiService
import com.example.newyorktimesbooks.domain.Repository
import com.example.newyorktimesbooks.domain.entitys.BooksEntity
import com.example.newyorktimesbooks.domain.entitys.CategoriesEntity
import com.example.newyorktimesbooks.domain.entitys.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import java.io.IOException

class RepositoryImpl(
    private val service: ApiService,
    private val mapper: Mapper,
    private val dao: Dao
) : Repository {
    private val categoriesState = MutableStateFlow<Resource<Unit>>(Resource.loading())
    private val booksState = MutableStateFlow<Resource<Unit>>(Resource.loading())
    override suspend fun loadCategories() {
        categoriesState.emit(Resource.loading())
        try {
            val response = service.loadCategory()
            if (response.isSuccessful) {
                val categoryDb = response.body()?.resultCategories
                    ?.map { mapper.mapCategoriesDtoToDb(it) }
                if (categoryDb != null)
                    dao.insertCategoriesList(categoryDb)
                categoriesState.emit(Resource.success(Unit))
            } else throw Exception(response.message())
        } catch (e: IOException) {
            categoriesState.emit(Resource.internetError())
        } catch (e: Exception) {
            categoriesState.emit(Resource.error(Throwable(e.message)))
        }
    }

    override fun getCategories(): Flow<List<CategoriesEntity>> =
        dao.getCategoriesList().map {
            it.map { categoryDb ->
                mapper.mupCategoriesDbToEntity(categoryDb)
            }
        }

    override fun getCategoriesState(): StateFlow<Resource<Unit>> = categoriesState.asStateFlow()

    override suspend fun loadBooks(category: String) {
        try {
            booksState.emit(Resource.loading())
            val response = service.loadBooksByCategory(categoryName = category)
            if (response.isSuccessful) {
                val categoryName = response.body()?.resultsBooks?.listName ?: UNKNOWN_NAME
                val booksDb = response.body()?.resultsBooks?.booksListDtos?.map {
                    mapper.mapBookDtoToDb(categoryName, it)
                }
                if (booksDb != null)
                    dao.insertBooksList(booksDb)
                booksState.emit(Resource.success(Unit))
            } else throw Exception(response.message())
        } catch (e: IOException) {
            booksState.emit(Resource.internetError())
        } catch (e: Exception) {
            booksState.emit(Resource.error(Throwable(e.message)))
        }
    }

    override fun getBooksListState(): StateFlow<Resource<Unit>> =
        booksState.asStateFlow()

    override fun getBooksList(categoryName: String): Flow<List<BooksEntity>> =
        dao.getBooksList(categoryName).map {
            it.map { booksDb -> mapper.mapBookDbToEntity(booksDb) }
        }

    companion object {
        private const val UNKNOWN_NAME = "Unknown name"
    }
}
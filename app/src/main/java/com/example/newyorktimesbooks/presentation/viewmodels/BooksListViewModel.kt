package com.example.newyorktimesbooks.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyorktimesbooks.domain.entitys.BooksEntity
import com.example.newyorktimesbooks.domain.use_cases.GetBooksStateUseCase
import com.example.newyorktimesbooks.domain.use_cases.GetBooksUseCase
import com.example.newyorktimesbooks.domain.use_cases.LoadBooksUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BooksListViewModel(
    private val loadBooksUseCase: LoadBooksUseCase,
    getBooksStateUseCase: GetBooksStateUseCase,
    private val getBooksUseCase: GetBooksUseCase
) : ViewModel() {
    val getBooksState = getBooksStateUseCase()
    fun getBooks(categoryName: String): Flow<List<BooksEntity>> = getBooksUseCase(categoryName)

    fun loadBookByCategories(category: String) {
        viewModelScope.launch { loadBooksUseCase(category) }
    }
}
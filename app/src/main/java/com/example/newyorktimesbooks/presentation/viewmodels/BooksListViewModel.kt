package com.example.newyorktimesbooks.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyorktimesbooks.domain.use_cases.GetBooksUseCase
import com.example.newyorktimesbooks.domain.use_cases.LoadBooksUseCase
import kotlinx.coroutines.launch

class BooksListViewModel(
    private val loadBooksUseCase: LoadBooksUseCase,
    getBooksUseCase: GetBooksUseCase
) : ViewModel() {
    val getBooks = getBooksUseCase()
    fun loadBookByCategories(category: String) {
        viewModelScope.launch { loadBooksUseCase(category) }
    }
}
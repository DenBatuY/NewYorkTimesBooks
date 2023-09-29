package com.example.newyorktimesbooks.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyorktimesbooks.domain.use_cases.LoadBookByCategoriesUseCase
import kotlinx.coroutines.launch

class BooksListViewModel(
    private val loadBookByCategoriesUseCase: LoadBookByCategoriesUseCase
) : ViewModel() {
    fun loadBookByCategories(category: String) {
        viewModelScope.launch { loadBookByCategoriesUseCase(category) }
    }
}
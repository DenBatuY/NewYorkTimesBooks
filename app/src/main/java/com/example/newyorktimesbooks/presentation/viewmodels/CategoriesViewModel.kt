package com.example.newyorktimesbooks.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyorktimesbooks.domain.use_cases.GetCategoriesStateUseCase
import com.example.newyorktimesbooks.domain.use_cases.GetCategoriesUseCase
import com.example.newyorktimesbooks.domain.use_cases.LoadCategoriesUseCase
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val loadCategoriesUseCase: LoadCategoriesUseCase,
    getCategoriesUseCase: GetCategoriesUseCase,
    getCategoriesStateUseCase: GetCategoriesStateUseCase
) : ViewModel() {

    val categoryState = getCategoriesStateUseCase()

    val getCategories = getCategoriesUseCase()
    fun loadCategories() {
        viewModelScope.launch { loadCategoriesUseCase() }
    }
}
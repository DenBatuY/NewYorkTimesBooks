package com.example.newyorktimesbooks.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyorktimesbooks.domain.use_cases.GetCategoriesUseCase
import com.example.newyorktimesbooks.domain.use_cases.LoadCategoriesUseCase
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val loadCategoriesUseCase: LoadCategoriesUseCase,
    getCategoriesUseCase: GetCategoriesUseCase
):ViewModel() {

    val category = getCategoriesUseCase()
    fun loadCategories(){
        viewModelScope.launch { loadCategoriesUseCase() }
    }
}
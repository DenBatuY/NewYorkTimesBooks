package com.example.newyorktimesbooks.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyorktimesbooks.domain.use_cases.LoadCategoriesUseCase
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val loadCategoriesUseCase: LoadCategoriesUseCase
):ViewModel() {
    fun loadCategories(){
        viewModelScope.launch { loadCategoriesUseCase() }
    }
}
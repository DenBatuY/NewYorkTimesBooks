package com.example.newyorktimesbooks.domain.use_cases

import com.example.newyorktimesbooks.domain.Repository

class LoadBookByCategoriesUseCase(private val repository: Repository) {
    suspend operator fun invoke(category:String) = repository.loadBooksByCategory(category)
}
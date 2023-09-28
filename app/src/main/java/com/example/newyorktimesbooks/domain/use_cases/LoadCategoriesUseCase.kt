package com.example.newyorktimesbooks.domain.use_cases

import com.example.newyorktimesbooks.domain.Repository

class LoadCategoriesUseCase(private val repository: Repository) {
    suspend operator fun invoke() = repository.loadCategories()
}
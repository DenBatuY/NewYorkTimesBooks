package com.example.newyorktimesbooks.domain.use_cases

import com.example.newyorktimesbooks.domain.Repository

class GetCategoriesUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getCategories()
}
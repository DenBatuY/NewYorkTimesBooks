package com.example.newyorktimesbooks.domain.use_cases

import com.example.newyorktimesbooks.domain.Repository

class LoadBooksUseCase(private val repository: Repository) {
    suspend operator fun invoke(category:String) = repository.loadBooks(category)
}
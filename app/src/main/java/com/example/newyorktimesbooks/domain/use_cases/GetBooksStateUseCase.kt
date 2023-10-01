package com.example.newyorktimesbooks.domain.use_cases

import com.example.newyorktimesbooks.domain.Repository

class GetBooksStateUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getBooksListState()
}
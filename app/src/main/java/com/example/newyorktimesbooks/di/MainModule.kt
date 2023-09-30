package com.example.newyorktimesbooks.di

import com.example.newyorktimesbooks.data.Mapper
import com.example.newyorktimesbooks.data.RepositoryImpl
import com.example.newyorktimesbooks.domain.Repository
import com.example.newyorktimesbooks.domain.use_cases.GetBooksUseCase
import com.example.newyorktimesbooks.domain.use_cases.GetCategoriesUseCase
import com.example.newyorktimesbooks.domain.use_cases.LoadBooksUseCase
import com.example.newyorktimesbooks.domain.use_cases.LoadCategoriesUseCase
import com.example.newyorktimesbooks.presentation.viewmodels.BooksListViewModel
import com.example.newyorktimesbooks.presentation.viewmodels.CategoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MainModule = module {

    viewModel<CategoriesViewModel> { CategoriesViewModel(get(),get()) }
    viewModel<BooksListViewModel> { BooksListViewModel(get(),get()) }

    single<Repository> { RepositoryImpl(get(), get()) }
    factory { Mapper() }
    factory { LoadCategoriesUseCase(get()) }
    factory { LoadBooksUseCase(get()) }
    factory { GetCategoriesUseCase(get()) }
    factory { GetBooksUseCase(get()) }
}
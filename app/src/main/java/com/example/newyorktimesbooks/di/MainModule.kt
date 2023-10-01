package com.example.newyorktimesbooks.di

import com.example.newyorktimesbooks.data.Mapper
import com.example.newyorktimesbooks.data.RepositoryImpl
import com.example.newyorktimesbooks.domain.Repository
import com.example.newyorktimesbooks.domain.use_cases.GetBooksStateUseCase
import com.example.newyorktimesbooks.domain.use_cases.GetBooksUseCase
import com.example.newyorktimesbooks.domain.use_cases.GetCategoriesStateUseCase
import com.example.newyorktimesbooks.domain.use_cases.GetCategoriesUseCase
import com.example.newyorktimesbooks.domain.use_cases.LoadBooksUseCase
import com.example.newyorktimesbooks.domain.use_cases.LoadCategoriesUseCase
import com.example.newyorktimesbooks.presentation.viewmodels.BooksListViewModel
import com.example.newyorktimesbooks.presentation.viewmodels.CategoriesViewModel
import com.google.gson.Gson
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MainModule = module {

    viewModel<CategoriesViewModel> { CategoriesViewModel(get(), get(), get()) }
    viewModel<BooksListViewModel> { BooksListViewModel(get(), get(), get()) }

    single<Repository> { RepositoryImpl(get(), get(), get()) }
    single { Gson() }
    factory { Mapper(get()) }
    factory { LoadCategoriesUseCase(get()) }
    factory { LoadBooksUseCase(get()) }
    factory { GetCategoriesUseCase(get()) }
    factory { GetBooksStateUseCase(get()) }
    factory { GetCategoriesStateUseCase(get()) }
    factory { GetBooksUseCase(get()) }
}
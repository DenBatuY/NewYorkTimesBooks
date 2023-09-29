package com.example.newyorktimesbooks.di

import com.example.newyorktimesbooks.data.Mapper
import com.example.newyorktimesbooks.data.RepositoryImpl
import com.example.newyorktimesbooks.domain.Repository
import com.example.newyorktimesbooks.domain.use_cases.LoadBookByCategoriesUseCase
import com.example.newyorktimesbooks.domain.use_cases.LoadCategoriesUseCase
import com.example.newyorktimesbooks.presentation.BooksListViewModel
import com.example.newyorktimesbooks.presentation.CategoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MainModule = module {

    viewModel<CategoriesViewModel> { CategoriesViewModel(get()) }
    viewModel<BooksListViewModel> { BooksListViewModel(get()) }

    single<Repository> { RepositoryImpl(get(), get()) }
    factory { Mapper() }
    factory { LoadCategoriesUseCase(get()) }
    factory { LoadBookByCategoriesUseCase(get()) }
}
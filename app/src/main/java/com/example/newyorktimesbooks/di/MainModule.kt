package com.example.newyorktimesbooks.di

import com.example.newyorktimesbooks.data.RepositoryImpl
import com.example.newyorktimesbooks.data.network.ApiFactory
import com.example.newyorktimesbooks.data.network.ApiService
import com.example.newyorktimesbooks.domain.Repository
import com.example.newyorktimesbooks.domain.use_cases.LoadCategoriesUseCase
import com.example.newyorktimesbooks.presentation.CategoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MainModule = module {

    single<ApiService> { ApiFactory.apiService }

    viewModel<CategoriesViewModel> { CategoriesViewModel(get()) }

    single<Repository> { RepositoryImpl(get()) }

    factory { LoadCategoriesUseCase(get()) }
}
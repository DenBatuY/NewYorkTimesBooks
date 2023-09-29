package com.denbatuy.core.di

import com.denbatuy.core.network.ApiFactory
import com.denbatuy.core.network.ApiService
import org.koin.dsl.module

val CoreModule = module{
    single<ApiService> { ApiFactory.apiService }
}
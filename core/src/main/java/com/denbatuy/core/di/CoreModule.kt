package com.denbatuy.core.di

import com.denbatuy.core.db.Dao
import com.denbatuy.core.db.DataBase
import com.denbatuy.core.network.ApiFactory
import com.denbatuy.core.network.ApiService
import org.koin.dsl.module

val CoreModule = module {
    single<ApiService> { ApiFactory.apiService }
    single<Dao> { DataBase.getInstance(get()).bookStorageDao() }
}
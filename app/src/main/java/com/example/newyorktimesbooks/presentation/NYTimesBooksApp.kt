package com.example.newyorktimesbooks.presentation

import android.app.Application
import com.denbatuy.core.di.CoreModule
import com.example.newyorktimesbooks.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NYTimesBooksApp:Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NYTimesBooksApp)
            modules(listOf(MainModule, CoreModule))
        }
    }
}
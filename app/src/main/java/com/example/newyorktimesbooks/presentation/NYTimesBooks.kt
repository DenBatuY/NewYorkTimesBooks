package com.example.newyorktimesbooks.presentation

import android.app.Application
import com.example.newyorktimesbooks.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NYTimesBooks:Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@NYTimesBooks)
            modules(listOf(MainModule))
        }
    }
}
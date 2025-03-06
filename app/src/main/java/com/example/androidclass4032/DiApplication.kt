package com.example.androidclass4032

import android.app.Application
import com.example.androidclass4032.di.appModules
import org.koin.core.context.startKoin

class DiApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(appModules)
        }
    }
}
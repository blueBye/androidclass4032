package com.example.androidclass4032.di

import com.example.androidclass4032.data.PetsRepository
import com.example.androidclass4032.data.PetsRepositoryImpl
import com.example.androidclass4032.viewmodel.PetsViewModel
import org.koin.dsl.module

val appModules = module {
    single<PetsRepository> { PetsRepositoryImpl() }
    single { PetsViewModel(get()) }
}
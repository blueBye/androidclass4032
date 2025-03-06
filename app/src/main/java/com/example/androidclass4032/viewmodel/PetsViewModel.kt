package com.example.androidclass4032.viewmodel

import androidx.lifecycle.ViewModel
import com.example.androidclass4032.data.PetsRepository
import com.example.androidclass4032.data.PetsRepositoryImpl

class PetsViewModel: ViewModel() {
    private val petsRepository: PetsRepository = PetsRepositoryImpl()

    fun getPets() = petsRepository.getPets()
}
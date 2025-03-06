package com.example.androidclass4032.viewmodel

import androidx.lifecycle.ViewModel
import com.example.androidclass4032.data.PetsRepository
import com.example.androidclass4032.data.PetsRepositoryImpl

class PetsViewModel(
    private val petsRepository: PetsRepository
): ViewModel() {
    fun getPets() = petsRepository.getPets()
}
package com.calculator.calculatorkotlin.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.repository.DirectionRepository

class HomeVM(var repository: DirectionRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeVM(repository) as T
    }
}
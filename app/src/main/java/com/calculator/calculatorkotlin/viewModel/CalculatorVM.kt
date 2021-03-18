package com.calculator.calculatorkotlin.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.repository.CalculatorRepository

class CalculatorVM(var repository: CalculatorRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CalculatorVM(repository) as T
    }
}
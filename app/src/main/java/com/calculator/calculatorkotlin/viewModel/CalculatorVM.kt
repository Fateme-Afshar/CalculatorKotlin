package com.calculator.calculatorkotlin.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.repository.CalculatorRepository
import com.calculator.calculatorkotlin.repository.DirectionRepository

class CalculatorVM(var repository: CalculatorRepository,
                   var directionRepository: DirectionRepository,
                   var directionIdOne:Int=0,
                   var directionIdTwo: Int=0) : ViewModelProvider.Factory {
    lateinit var directionOne:DirectionModel
    lateinit var directionTwo:DirectionModel
    init {
        directionRepository.get(directionIdOne).observeForever {
            directionOne=it
        }

        directionRepository.get(directionIdTwo).observeForever { directionTwo=it }
    }

    fun onCalculateBtnClickListener(){

    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CalculatorVM(repository,directionRepository,directionIdOne,directionIdTwo) as T
    }
}
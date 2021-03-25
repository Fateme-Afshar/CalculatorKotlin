package com.calculator.calculatorkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.model.CalculateModel
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.repository.CalculatorRepository
import com.calculator.calculatorkotlin.repository.DirectionRepository

class BaseVM(private var repository: DirectionRepository,private var calculatorRepository: CalculatorRepository):ViewModelProvider.Factory {
    private var selectionDirections=MutableLiveData<List<DirectionModel>>()

    fun deleteDirectionModel(directionModel: DirectionModel){
        repository.delete(directionModel)
    }

    fun getSelectionDirections(): MutableLiveData<List<DirectionModel>> {
        return selectionDirections
    }

    fun getDirectionList(): LiveData<List<DirectionModel>> {
        return repository.get()
    }

    fun getCalculatedDirectionList():LiveData<List<CalculateModel>>{
        return calculatorRepository.get()
    }

    fun deleteAllDirections(){
        repository.deleteAll()
    }

    fun deleteAllCalculates(){
        calculatorRepository.deleteAll()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BaseVM(repository,calculatorRepository) as T
    }
}
package com.calculator.calculatorkotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.repository.DirectionRepository

class BaseVM(var repository: DirectionRepository):ViewModelProvider.Factory {
    private var selectionDirections=MutableLiveData<List<DirectionModel>>()

    fun deleteDirectionModel(directionModel: DirectionModel){
        repository.delete(directionModel)
    }

    fun getSelectionDirections(): MutableLiveData<List<DirectionModel>> {
        return selectionDirections
    }

    fun deleteAll(){
        repository.deleteAll()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BaseVM(repository) as T
    }
}
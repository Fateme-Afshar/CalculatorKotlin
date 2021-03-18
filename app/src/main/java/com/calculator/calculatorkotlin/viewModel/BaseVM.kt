package com.calculator.calculatorkotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.repository.DirectionRepository

class BaseVM(var repository: DirectionRepository):ViewModel() {
    private var selectionDirections=MutableLiveData<List<DirectionModel>>()

    fun deleteDirectionModel(directionModel: DirectionModel){
        repository.delete(directionModel)
    }

    fun getSelectionDirections(): MutableLiveData<List<DirectionModel>> {
        return selectionDirections
    }
}
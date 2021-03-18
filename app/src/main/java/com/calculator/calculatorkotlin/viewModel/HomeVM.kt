package com.calculator.calculatorkotlin.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.repository.DirectionRepository

class HomeVM(var repository: DirectionRepository):ViewModelProvider.Factory {

    fun getDirectionList():LiveData<List<DirectionModel>>{
        return repository.get()
    }

    fun deleteDirectionModel(directionModel: DirectionModel){
        repository.delete(directionModel)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeVM(repository) as T
    }
}
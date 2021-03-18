package com.calculator.calculatorkotlin.viewModel

import android.app.Application
import android.text.Editable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.repository.DirectionRepository

class AddDirectionVM(var application: Application,var repository: DirectionRepository) : ViewModelProvider.Factory{
    private var directionModel=DirectionModel()

    fun afterTextChangedX(editable: Editable){
        directionModel.x=editable.toString().toFloat()
    }

    fun afterTextChangedY(editable: Editable){
        directionModel.y=editable.toString().toFloat()
    }

    fun addDirectionModel(){
        repository.insert(directionModel)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddDirectionVM(application,repository) as T
    }
}
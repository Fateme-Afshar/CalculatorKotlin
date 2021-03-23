package com.calculator.calculatorkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.model.CalculateModel
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.repository.CalculatorRepository
import kotlin.math.pow
import kotlin.math.sqrt

class CalculatorVM(
    var repository: CalculatorRepository,
    var directionOne: DirectionModel,
    var directionTwo: DirectionModel
) : ViewModelProvider.Factory {
    var result: Float=0.0f
    private var directionList= mutableListOf<DirectionModel>()
    private var btnClickListener=MutableLiveData<String>()

    init {
        directionList.apply {
            this.add(directionOne)
            this.add(directionTwo)
        }
    }

    fun onCalculateBtnClickListener(){
        var resultRaw=sqrt(
            (directionTwo.x - directionOne.x).toDouble().pow(2.0) +
                    (directionTwo.y - directionOne.y).toDouble().pow(2.0)
        ).toFloat()

        val num = String.format("%.2f", resultRaw)

        result=num.toFloat()

        btnClickListener.value=result.toString()
    }

    fun onSaveBtnClickListener(){
        repository.insert(CalculateModel(directionList,result))
    }

    fun getBtnClickListener():LiveData<String>{
        return btnClickListener;
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CalculatorVM(repository, directionOne, directionTwo) as T
    }
}
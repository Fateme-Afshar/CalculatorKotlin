package com.calculator.calculatorkotlin.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.calculator.calculatorkotlin.model.CalculateModel
import com.calculator.calculatorkotlin.room.CalculatorDatabase

class CalculatorRepository private constructor(var context: Context) : IRepository<CalculateModel>{
    private var database=CalculatorDatabase.getInstance(context.applicationContext)
    private var calculatorDao=database.calculatorDao()

    override fun get(id: Int): LiveData<CalculateModel> {
        return calculatorDao.get(id)
    }

    override fun get(): LiveData<List<CalculateModel>> {
        return calculatorDao.get()
    }

    override fun delete(calculatorModel: CalculateModel) {
        database.executorDatabase.execute{calculatorDao.delete(calculatorModel)}
    }

    override fun insert(calculatorModel: CalculateModel) {
        database.executorDatabase.execute{calculatorDao.insert(calculatorModel)}
    }

    override fun update(calculatorModel: CalculateModel) {
        database.executorDatabase.execute{calculatorDao.update(calculatorModel)}
    }
}
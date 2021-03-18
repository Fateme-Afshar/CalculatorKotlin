package com.calculator.calculatorkotlin.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.room.CalculatorDatabase

class DirectionRepository private constructor(context: Context) : IRepository<DirectionModel> {
    private var calculatorDatabase:CalculatorDatabase = CalculatorDatabase.getInstance(context.applicationContext)
    private val directionDao = calculatorDatabase.directionDao()

    companion object {
        private var instance: DirectionRepository? = null
        fun getInstance(context: Context): DirectionRepository {
            if (instance == null)
                instance = DirectionRepository(context)
            return instance as DirectionRepository
        }
    }

    override fun get(id: Int): LiveData<DirectionModel> {
        return directionDao.get(id)
    }

    override fun get(): LiveData<List<DirectionModel>> {
        return directionDao.get()
    }

    override fun delete(directionModel: DirectionModel) {
        calculatorDatabase.executorDatabase.execute { directionDao.delete(directionModel) }
    }

    override fun insert(directionModel: DirectionModel) {
        calculatorDatabase.executorDatabase.execute { directionDao.insert(directionModel) }
    }

    override fun update(directionModel: DirectionModel) {
        calculatorDatabase.executorDatabase.execute { directionDao.update(directionModel) }
    }
}
package com.calculator.calculatorkotlin.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.calculator.calculatorkotlin.model.CalculateModel

@Dao
interface CalculatorDao {
    @Query(value = "select * from calculatorTable where id=:id")
    fun get(id: Int) : LiveData<CalculateModel>
    @Query(value = "select * from calculatorTable")
    fun get() : LiveData<List<CalculateModel>>
    @Insert
    fun insert(calculateModel: CalculateModel)
    @Delete
    fun delete(calculateModel: CalculateModel)
    @Update
    fun update(calculateModel: CalculateModel)
    @Query(value = "delete from calculatorTable")
    fun deleteAll()
}
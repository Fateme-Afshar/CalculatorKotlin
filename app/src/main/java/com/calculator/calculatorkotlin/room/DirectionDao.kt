package com.calculator.calculatorkotlin.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.calculator.calculatorkotlin.model.DirectionModel

@Dao
interface DirectionDao {
    @Query(value = "select * from directionTable where id=:id")
    fun get(id: Int) :LiveData<DirectionModel>
    @Query(value = "select * from directionTable")
    fun get() : LiveData<List<DirectionModel>>
    @Insert
    fun insert(directionModel: DirectionModel)
    @Delete
    fun delete(directionModel: DirectionModel)
    @Update
    fun update(directionModel: DirectionModel)
}
package com.calculator.calculatorkotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calculatorTable")
data class CalculateModel(@ColumnInfo(name = "listDirModel") var listOfDirectionModel: List<DirectionModel>,
                          @ColumnInfo(name = "result")var result:Float=0f) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int=0
}
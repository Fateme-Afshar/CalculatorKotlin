package com.calculator.calculatorkotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "directionTable")
data class DirectionModel(@ColumnInfo(name = "x")var x:Float=0f, @ColumnInfo(name = "y")var y:Float=0f) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int=0
}
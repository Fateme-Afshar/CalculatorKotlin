package com.calculator.calculatorkotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "directionTable")
data class DirectionModel(@ColumnInfo(name = "x")var x:Float=0f, @ColumnInfo(name = "y")var y:Float=0f) : Serializable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int=0
}
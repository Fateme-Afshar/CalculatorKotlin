package com.calculator.calculatorkotlin.room

import androidx.room.TypeConverter
import com.calculator.calculatorkotlin.model.DirectionModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converter {
    @TypeConverter
    fun conListToJsonStr(list: List<DirectionModel>?):String?{
        return list?.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun conStrToListDirection(jsonStr: String?):List<DirectionModel>?{
        return jsonStr.let {
            Gson().fromJson<List<DirectionModel>>(
                it,
                object : TypeToken<List<DirectionModel?>?>() {}.type
            ) }
    }
}
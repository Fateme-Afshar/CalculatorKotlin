package com.calculator.calculatorkotlin.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.calculator.calculatorkotlin.model.DirectionModel
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [DirectionModel::class], version = 1)
@TypeConverters
abstract class CalculatorDatabase :RoomDatabase(){
    abstract fun directionDao(): DirectionDao
    abstract fun calculatorDao():CalculatorDao

    val executorDatabase: ExecutorService = Executors.newFixedThreadPool(5)

    companion object {
        @Volatile
        private var INSTANCE: CalculatorDatabase? = null

        fun getInstance(context: Context) :CalculatorDatabase{
            synchronized(this){
                var instance= INSTANCE

                if (instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CalculatorDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}
package com.calculator.calculatorkotlin.repository

import androidx.lifecycle.LiveData

interface IRepository<T> {
    fun get(id:Int):LiveData<T>
    fun get():LiveData<List<T>>
    fun delete(t:T)
    fun insert(t:T)
    fun update(t:T)
}
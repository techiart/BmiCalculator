package com.inspirecoding.bmicalculator.data.source

import androidx.lifecycle.LiveData
import com.inspirecoding.bmicalculator.data.BmiRepository
import com.inspirecoding.bmicalculator.model.BMI

class FakeBmiRepository(var bmis: MutableList<BMI>? = mutableListOf()) : BmiRepository
{
    suspend fun getListOfBmi() = bmis

    override val allBmi: LiveData<List<BMI>>
        get() = TODO("Not yet implemented")

    override suspend fun insertBmi(bmi: BMI) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBmi(bmi: BMI) {
        TODO("Not yet implemented")
    }
}
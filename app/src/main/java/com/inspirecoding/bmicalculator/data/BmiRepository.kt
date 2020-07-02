package com.inspirecoding.bmicalculator.data

import androidx.lifecycle.LiveData
import com.inspirecoding.bmicalculator.model.BMI

class BmiRepository(private val bmiDao: BmiDao)
{
    val allBmi: LiveData<List<BMI>> = bmiDao.getAllBmi()

    suspend fun insertBmi(bmi: BMI)
    {
        bmiDao.insertBmi(bmi)
    }

    suspend fun deleteBmi(bmi: BMI)
    {
        bmiDao.deleteBmi(bmi)
    }
}
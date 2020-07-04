package com.inspirecoding.bmicalculator.data

import androidx.lifecycle.LiveData
import com.inspirecoding.bmicalculator.model.BMI

class BmiRepositoryImpl(private val bmiDao: BmiDao) : BmiRepository
{
    override val allBmi: LiveData<List<BMI>> = bmiDao.getAllBmi()

    override suspend fun insertBmi(bmi: BMI)
    {
        bmiDao.insertBmi(bmi)
    }

    override suspend fun deleteBmi(bmi: BMI)
    {
        bmiDao.deleteBmi(bmi)
    }
}
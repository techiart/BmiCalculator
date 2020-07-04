package com.inspirecoding.bmicalculator.data

import androidx.lifecycle.LiveData
import com.inspirecoding.bmicalculator.model.BMI

interface BmiRepository
{
    val allBmi: LiveData<List<BMI>>

    suspend fun insertBmi(bmi: BMI)

    suspend fun deleteBmi(bmi: BMI)
}
package com.inspirecoding.bmicalculator.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.inspirecoding.bmicalculator.model.BMI

@Dao
interface BmiDao
{
    @Insert
    suspend fun insertBmi(bmi: BMI)

    @Delete
    suspend fun deleteBmi(bmi: BMI)

    @Query("SELECT * FROM BMI")
    fun getAllBmi(): LiveData<List<BMI>>
}
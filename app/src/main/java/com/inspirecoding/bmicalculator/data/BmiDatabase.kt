package com.inspirecoding.bmicalculator.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.inspirecoding.bmicalculator.model.BMI

@Database(entities = [BMI::class], version = 1, exportSchema = false)
abstract class BmiDatabase: RoomDatabase()
{
    abstract fun bmiDao(): BmiDao
}
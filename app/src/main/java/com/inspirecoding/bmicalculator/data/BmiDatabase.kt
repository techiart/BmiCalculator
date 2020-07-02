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

    companion object
    {
        @Volatile
        private var INSTANCE: BmiDatabase? = null

        fun getDatabase(context: Context): BmiDatabase
        {
            val tempInstance = INSTANCE

            if(tempInstance != null)
            {
                return tempInstance
            }
            synchronized(BmiDatabase::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BmiDatabase::class.java,
                    "bmi_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
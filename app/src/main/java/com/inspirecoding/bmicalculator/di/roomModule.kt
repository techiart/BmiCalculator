package com.inspirecoding.bmicalculator.di

import androidx.room.Room
import com.inspirecoding.bmicalculator.data.BmiDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    /** Provided room components **/
    single {
        Room.databaseBuilder(androidApplication(), BmiDatabase::class.java, "bmi_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    /** Provided bmis DAO **/
    single {
        get<BmiDatabase>().bmiDao()
    }
}
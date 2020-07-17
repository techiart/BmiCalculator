package com.inspirecoding.bmicalculator.di

import android.app.Application
import com.inspirecoding.bmicalculator.data.BmiDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomDatabaseModule
{
    @Singleton
    @Provides
    fun provideDatabase(application: Application) = BmiDatabase.getDatabase(application)

    @Singleton
    @Provides
    fun provideArticleDao(database: BmiDatabase) = database.bmiDao()
}
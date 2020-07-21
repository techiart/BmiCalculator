package com.inspirecoding.bmicalculator.di.module

import android.content.Context
import com.inspirecoding.bmicalculator.data.BmiDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn (ApplicationComponent::class)
@Module
class BmiDatabaseModule
{
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ) = BmiDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideBmisDao (database: BmiDatabase) = database.bmiDao()
}
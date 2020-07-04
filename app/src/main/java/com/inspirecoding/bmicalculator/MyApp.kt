package com.inspirecoding.bmicalculator

import android.app.Application
import com.inspirecoding.bmicalculator.di.bmiModule
import com.inspirecoding.bmicalculator.di.roomModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application()
{
    override fun onCreate()
    {
        super.onCreate()

        val appModule = listOf(bmiModule)
        startKoin {
            androidContext(this@MyApp)
            modules(appModule + roomModule)
        }
    }
}
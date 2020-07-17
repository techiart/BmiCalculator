package com.inspirecoding.bmicalculator.di

import com.inspirecoding.bmicalculator.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule
{
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun bindMainActivity(): MainActivity
}
package com.inspirecoding.bmicalculator.di

import com.inspirecoding.bmicalculator.addnewbmi.AddNewBmiFragment
import com.inspirecoding.bmicalculator.bmis.BmisFragment
import com.inspirecoding.bmicalculator.result.ResultFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule
{
    @ContributesAndroidInjector
    abstract fun contributeBmisFragment() : BmisFragment

    @ContributesAndroidInjector
    abstract fun contributeAddNewBmiFragment() : AddNewBmiFragment

    @ContributesAndroidInjector
    abstract fun contributeResultFragment() : ResultFragment
}
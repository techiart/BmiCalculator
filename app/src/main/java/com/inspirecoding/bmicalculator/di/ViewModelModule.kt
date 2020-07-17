package com.inspirecoding.bmicalculator.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.inspirecoding.bmicalculator.addnewbmi.AddNewBmiViewModel
import com.inspirecoding.bmicalculator.bmis.BmisViewModel
import com.inspirecoding.bmicalculator.result.ResultViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule
{
    @Binds
    @IntoMap
    @ViewModelKey(BmisViewModel::class)
    abstract fun bindBmisViewModel(bmisViewModel: BmisViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(AddNewBmiViewModel::class)
    abstract fun bindAddNewBmiViewModel(bmisViewModel: AddNewBmiViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(ResultViewModel::class)
    abstract fun bindResultViewModel(resultViewModel: ResultViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}
package com.inspirecoding.bmicalculator.di

import com.inspirecoding.bmicalculator.bmis.BmisViewModel
import com.inspirecoding.bmicalculator.data.BmiRepository
import com.inspirecoding.bmicalculator.data.BmiRepositoryImpl
import com.inspirecoding.bmicalculator.result.ResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val bmiModule = module {

    single<BmiRepository> { BmiRepositoryImpl(get()) }

    viewModel { BmisViewModel(get()) }
    viewModel { ResultViewModel(get()) }

}
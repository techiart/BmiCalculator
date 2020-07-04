package com.inspirecoding.bmicalculator.bmis

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.inspirecoding.bmicalculator.data.BmiDatabase
import com.inspirecoding.bmicalculator.data.BmiRepository
import com.inspirecoding.bmicalculator.data.BmiRepositoryImpl
import com.inspirecoding.bmicalculator.model.BMI

class BmisViewModel(private val bmiRepository: BmiRepository) : ViewModel()
{
    val items: LiveData<List<BMI>> = bmiRepository.allBmi
}
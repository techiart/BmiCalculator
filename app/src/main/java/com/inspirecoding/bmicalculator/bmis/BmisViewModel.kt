package com.inspirecoding.bmicalculator.bmis

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.inspirecoding.bmicalculator.data.BmiDatabase
import com.inspirecoding.bmicalculator.data.BmiRepository
import com.inspirecoding.bmicalculator.model.BMI

class BmisViewModel(application: Application) : AndroidViewModel(application)
{
    private val bmiRepository: BmiRepository

    init
    {
        val bmiDao = BmiDatabase.getDatabase(application.applicationContext).bmiDao()
        bmiRepository = BmiRepository(bmiDao)
    }

    val items: LiveData<List<BMI>> = bmiRepository.allBmi
}
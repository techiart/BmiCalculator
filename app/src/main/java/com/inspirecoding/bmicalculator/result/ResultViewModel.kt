package com.inspirecoding.bmicalculator.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inspirecoding.bmicalculator.model.BMI

class ResultViewModel : ViewModel()
{
    private val _resultBmi = MutableLiveData<BMI>()
    val resultBmi: LiveData<BMI> = _resultBmi
    private val _resultCalculatedBmi = MutableLiveData<Float>()
    val resultCalculatedBmi: LiveData<Float> = _resultCalculatedBmi

    fun getBmi(bmi: BMI?)
    {
        _resultBmi.value = bmi
        _resultCalculatedBmi.value = calculateBmi(bmi)
    }

    fun calculateBmi(bmi: BMI?): Float
    {
        return bmi?.bmi() ?: 0f
    }
}
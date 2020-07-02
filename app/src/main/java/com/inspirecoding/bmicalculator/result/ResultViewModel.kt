package com.inspirecoding.bmicalculator.result

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.inspirecoding.bmicalculator.Event
import com.inspirecoding.bmicalculator.data.BmiDatabase
import com.inspirecoding.bmicalculator.data.BmiRepository
import com.inspirecoding.bmicalculator.model.BMI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultViewModel(application: Application) : AndroidViewModel(application)
{
    private val bmiRepository: BmiRepository

    private val _resultBmi = MutableLiveData<BMI>()
    val resultBmi: LiveData<BMI> = _resultBmi
    private val _resultCalculatedBmi = MutableLiveData<Float>()
    val resultCalculatedBmi: LiveData<Float> = _resultCalculatedBmi

    private val _bmiSaveEvent = MutableLiveData<Event<Unit>>()
    val bmiSaveEvent: LiveData<Event<Unit>> = _bmiSaveEvent

    init
    {
        val bmiDao = BmiDatabase.getDatabase(application.applicationContext).bmiDao()
        bmiRepository = BmiRepository(bmiDao)
    }


    fun getBmi(bmi: BMI?)
    {
        _resultBmi.value = bmi
        _resultCalculatedBmi.value = calculateBmi(bmi)
    }

    fun calculateBmi(bmi: BMI?): Float
    {
        return bmi?.bmi() ?: 0f
    }


    fun saveBmi()
    {
        resultBmi.value?.let { _bmi ->
            viewModelScope.launch(Dispatchers.IO) {
                bmiRepository.insertBmi(_bmi)
                _bmiSaveEvent.postValue(Event(Unit))
            }
        }
    }
}
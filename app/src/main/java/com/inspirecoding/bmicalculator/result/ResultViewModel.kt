package com.inspirecoding.bmicalculator.result

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspirecoding.bmicalculator.Event
import com.inspirecoding.bmicalculator.data.BmiRepositoryImpl
import com.inspirecoding.bmicalculator.model.BMI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ResultViewModel @ViewModelInject constructor (
    private val bmiRepositoryImpl: BmiRepositoryImpl
) : ViewModel()
{
    private val _resultBmi = MutableLiveData<BMI>()
    val resultBmi: LiveData<BMI> = _resultBmi
    private val _resultCalculatedBmi = MutableLiveData<Float>()
    val resultCalculatedBmi: LiveData<Float> = _resultCalculatedBmi

    private val _bmiSaveEvent = MutableLiveData<Event<Unit>>()
    val bmiSaveEvent: LiveData<Event<Unit>> = _bmiSaveEvent

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
                bmiRepositoryImpl.insertBmi(_bmi)
                _bmiSaveEvent.postValue(Event(Unit))
            }
        }
    }
}
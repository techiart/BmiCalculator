package com.inspirecoding.bmicalculator.result

import androidx.lifecycle.*
import com.inspirecoding.bmicalculator.Event
import com.inspirecoding.bmicalculator.data.BmiRepository
import com.inspirecoding.bmicalculator.data.BmiRepositoryImpl
import com.inspirecoding.bmicalculator.model.BMI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultViewModel(private val bmiRepository: BmiRepository) : ViewModel()
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
                bmiRepository.insertBmi(_bmi)
                _bmiSaveEvent.postValue(Event(Unit))
            }
        }
    }
}
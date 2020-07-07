package com.inspirecoding.bmicalculator.bmis

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import com.inspirecoding.bmicalculator.Event
import com.inspirecoding.bmicalculator.data.BmiDatabase
import com.inspirecoding.bmicalculator.data.BmiRepository
import com.inspirecoding.bmicalculator.data.BmiRepositoryImpl
import com.inspirecoding.bmicalculator.model.BMI
import kotlinx.coroutines.launch

class BmisViewModel(private val bmiRepository: BmiRepository) : ViewModel()
{
    val items: LiveData<List<BMI>> = bmiRepository.allBmi

    private val _deleteBmiDialog = MutableLiveData<Event<BMI>>()
    val deleteBmiDialog: LiveData<Event<BMI>> = _deleteBmiDialog

    fun openDeleteBmiDialog(view: View, bmi: BMI): Boolean
    {
        _deleteBmiDialog.value = Event(bmi)

        return false
    }

    fun deleteBmi(bmi: BMI)
    {
        viewModelScope.launch {
            bmiRepository.deleteBmi(bmi)
        }
    }
}
package com.inspirecoding.bmicalculator.bmis

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import com.inspirecoding.bmicalculator.Event
import com.inspirecoding.bmicalculator.data.BmiDatabase
import com.inspirecoding.bmicalculator.data.BmiRepository
import com.inspirecoding.bmicalculator.model.BMI
import kotlinx.coroutines.launch

class BmisViewModel(application: Application) : AndroidViewModel(application)
{
    private val bmiRepository: BmiRepository

    private val _deleteBmiDialog = MutableLiveData<Event<BMI>>()
    val deleteBmiDialog: LiveData<Event<BMI>> = _deleteBmiDialog

    init
    {
        val bmiDao = BmiDatabase.getDatabase(application.applicationContext).bmiDao()
        bmiRepository = BmiRepository(bmiDao)
    }

    val items: LiveData<List<BMI>> = bmiRepository.allBmi

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
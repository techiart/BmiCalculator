package com.inspirecoding.bmicalculator.addnewbmi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inspirecoding.bmicalculator.Event
import com.inspirecoding.bmicalculator.R
import com.inspirecoding.bmicalculator.model.BMI
import com.inspirecoding.bmicalculator.utils.getNowInString
import java.util.*
import javax.inject.Inject

class AddNewBmiViewModel @Inject constructor () : ViewModel()
{
    private val _snackbarText = MutableLiveData<Event<Int>>()
    val snackbarText: LiveData<Event<Int>> = _snackbarText

    private val _calculateBmiEvent = MutableLiveData<Event<Unit>>()
    val calculateBmiEvent: LiveData<Event<Unit>> = _calculateBmiEvent

    // Two-way databinding, exposing MutableLiveData
    val height = MutableLiveData<String>()
    // Two-way databinding, exposing MutableLiveData
    val weight = MutableLiveData<String>()

    lateinit var bmi: BMI

    fun calculateBmi()
    {
        val currentHeight = this.height.value
        val currentWeight = this.weight.value

        if (checkValuesCorrectness(currentHeight, currentWeight))
        {
            bmi = createBmiInstance(currentHeight!!, currentWeight!!)
            Log.d("AddNewBmiViewModel", "${bmi}")
            _calculateBmiEvent.value = Event(Unit)
        }
    }
    private fun checkValuesCorrectness(height: String?, weight: String?): Boolean
    {
        return when {
            height.isNullOrEmpty() -> {
                _snackbarText.value = Event(R.string.height_is_empty)
                false
            }
            weight.isNullOrEmpty() -> {
                _snackbarText.value = Event(R.string.weight_is_empty)
                false
            }
            else -> {
                true
            }
        }
    }
    private fun createBmiInstance(height: String, weight: String) = BMI(
        0,
        height.toInt(),
        weight.toInt(),
        Date().getNowInString()
    )
}
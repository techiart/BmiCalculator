package com.inspirecoding.bmicalculator.utils

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.inspirecoding.bmicalculator.R
import com.inspirecoding.bmicalculator.bmis.BmisListAdapter
import com.inspirecoding.bmicalculator.model.BMI


@BindingAdapter("app:getShortEvaluation")
fun getShortEvaluation(textView: TextView, bmi: Float)
{
    when
    {
        bmi <= BmiRanges.UNDERWEIGHT.value -> {
            textView.text = BMIState.Underweight.name
        }
        bmi <= BmiRanges.HEALTHY.value -> {
            textView.text = BMIState.Healthy.name
        }
        bmi <= BmiRanges.OVERWEIGHT.value -> {
            textView.text = BMIState.Overweight.name
        }
        else -> {
            textView.text = BMIState.Obese.name
        }
    }
}

@BindingAdapter("app:setBmiStateColor", "app:context")
fun setBmiStateColor(textView: TextView, bmi: Float, context: Context)
{
    when
    {
        bmi <= BmiRanges.UNDERWEIGHT.value -> {
            textView.setTextColor(ContextCompat.getColor(context, R.color.orange))
        }
        bmi <= BmiRanges.HEALTHY.value -> {
            textView.setTextColor(ContextCompat.getColor(context, R.color.green))
        }
        bmi <= BmiRanges.OVERWEIGHT.value -> {
            textView.setTextColor(ContextCompat.getColor(context, R.color.orange))
        }
        else -> {
            textView.setTextColor(ContextCompat.getColor(context, R.color.red))
        }
    }
}

@BindingAdapter("app:setBmiStateColor", "app:context")
fun setBmiStateColor(view: View, bmi: Float, context: Context)
{
    when
    {
        bmi <= BmiRanges.UNDERWEIGHT.value -> {
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.orange))
        }
        bmi <= BmiRanges.HEALTHY.value -> {
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.green))
        }
        bmi <= BmiRanges.OVERWEIGHT.value -> {
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.orange))
        }
        else -> {
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.red))
        }
    }
}

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<BMI>?)
{
    Log.d("setItems", "$items")
    items?.let {
        (listView.adapter as BmisListAdapter).submitList(items)
    }
}
package com.inspirecoding.bmicalculator.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class BMI(

    var bmiId: Int = 0,
    var height: Int = 0,
    var weight: Int = 0,
    val date: String = ""

): Parcelable
{
    fun bmi(): Float =
        weight.toFloat() /
                ((height.toFloat()/100)*(height.toFloat()/100))
}
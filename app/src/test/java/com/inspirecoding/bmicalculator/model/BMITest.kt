package com.inspirecoding.bmicalculator.model

import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Test

class BMITest
{
    // Given
    private val bmi_1 = BMI(
        height = 168,
        weight = 76,
        date = "23.06.2020"
    )

    @Test
    fun getCalculatedBmi_returnsBmi()
    {
        // When
        val calculatedBmi = bmi_1.bmi()

        // Then - Test failed
        assertThat(calculatedBmi, `is`(26.927439f))
    }
}
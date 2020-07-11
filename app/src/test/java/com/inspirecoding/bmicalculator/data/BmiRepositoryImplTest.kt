package com.inspirecoding.bmicalculator.data

import com.inspirecoding.bmicalculator.data.source.FakeBmiRepository
import com.inspirecoding.bmicalculator.model.BMI
import kotlinx.coroutines.runBlocking
import org.hamcrest.core.IsEqual
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BmiRepositoryImplTest
{
    // Given
    private val bmi_1 = BMI (
        height = 168,
        weight = 76,
        date = "23.06.2020"
    )
    // Given
    private val bmi_2 = BMI (
        height = 0,
        weight = 76,
        date = "23.06.2020"
    )

    private val listOfBmis = listOf(bmi_1, bmi_2).sortedBy { it.bmi() }

    private lateinit var fakeBmiRepository: FakeBmiRepository

    @Before
    fun createRepository()
    {
        fakeBmiRepository = FakeBmiRepository(listOfBmis.toMutableList())
    }

    @Test
    fun getBmis_requestAllBmisFromLocalDatabase() = runBlocking {
        val bmis = fakeBmiRepository.getListOfBmi()

        assertThat(bmis, IsEqual(listOfBmis))
    }
}
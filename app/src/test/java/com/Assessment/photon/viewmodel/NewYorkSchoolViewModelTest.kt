package com.Assessment.photon.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.Assessment.photon.Model.NewYorkSchool
import com.Assessment.photon.Model.NewYorkSchoolRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NewYorkSchoolViewModelTest {

    @get: Rule
    val instantTaskExecutorRule=  InstantTaskExecutorRule()
    private val testDispatcher= TestCoroutineDispatcher()
    private val repository : NewYorkSchoolRepository = mockk()
    private lateinit var viewModel: NewYorkSchoolViewModel

    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = NewYorkSchoolViewModel()
        viewModel.setRepository(repository)
    }

    @Test
    fun `fetchNewYorkSchool Success`(){
        val mockSchools = listOf(
            NewYorkSchool("dbn", "schoolname1", "boro1", "paragraph1","1"),
            NewYorkSchool("dbn", "schoolname2", "boro2", "paragraph2","2")
        )

        coEvery { repository.getNewYorkSchool() } returns mockSchools

        viewModel.fetchNewYorkSchool()

       assertEquals(mockSchools, viewModel.newYorkSchool.value)
    }

    @Test
    fun `fetchNewYorkSchool failure`(){
        val errorMessage = "Failed to fetch ny schools"

        coEvery { repository.getNewYorkSchool() } throws  RuntimeException(errorMessage)

        viewModel.fetchNewYorkSchool()

        assertNull(viewModel.newYorkSchool.value)
    }
}
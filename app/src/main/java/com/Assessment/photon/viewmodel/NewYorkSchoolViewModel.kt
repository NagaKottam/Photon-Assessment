package com.Assessment.photon.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Assessment.photon.Model.NewYorkSchool
import com.Assessment.photon.Model.NewYorkSchoolRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class NewYorkSchoolViewModel : ViewModel(){
    // Repository for accessing NewYork School data
    private var repository : NewYorkSchoolRepository  = NewYorkSchoolRepository()

    // MutableLiveData to hold the list of NewYork School
    private val _newYorkSchool = MutableLiveData<List<NewYorkSchool>>()
    val newYorkSchool : LiveData<List<NewYorkSchool>> = _newYorkSchool

    // Coroutine Exception Handler for error handling
    private val exceptionHandler = CoroutineExceptionHandler{_, exception ->
        Log.e(TAG, "Coroutine exception ${exception.message}", exception )
    }

    // To set the repository
    fun setRepository(repo : NewYorkSchoolRepository){
        repository = repo
    }

    // To fetch newyork school data.
    fun fetchNewYorkSchool(){
        viewModelScope.launch(exceptionHandler) {
            _newYorkSchool.value = repository.getNewYorkSchool()
        }
    }

    companion object{
        private const val TAG = "NewYorkSchoolViewModel"
    }
}
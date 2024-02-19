package com.Assessment.photon.Model

// Repository class for handling Newyork school data
class NewYorkSchoolRepository {
    // Accessing the retrofit service for newyork schools
    private val newYorkSchoolService  = RetrofitInstance.newYorkSchoolService

    // Function to fetch NewYork school data async
    suspend fun getNewYorkSchool() : List<NewYorkSchool>{
        return  newYorkSchoolService.getNewYorkSchools()
    }
}
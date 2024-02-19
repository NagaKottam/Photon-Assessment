package com.Assessment.photon.Model

import retrofit2.http.GET

// Interface defining API endpoint for NewYork School
interface NewYorkSchoolApiInterface {
    @GET("resource/s3k6-pzi2.json")
    suspend fun getNewYorkSchools() : List<NewYorkSchool>
}
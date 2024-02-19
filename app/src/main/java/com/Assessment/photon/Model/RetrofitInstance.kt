package com.Assessment.photon.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton object responsible for creating retrofit Instance
object RetrofitInstance {
    private const val BASE_URL ="https://data.cityofnewyork.us/"

    private val retrofit : Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Lazy initialized retrofit service for New York schools
    val newYorkSchoolService : NewYorkSchoolApiInterface by lazy {
        retrofit.create(NewYorkSchoolApiInterface::class.java)
    }
}
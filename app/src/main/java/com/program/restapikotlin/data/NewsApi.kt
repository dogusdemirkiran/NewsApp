package com.program.restapikotlin.data

import com.program.restapikotlin.data.model.ArcticlesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getTopHeadLines(@Query("country") country: String, @Query("apiKey") apiKey: String): ArcticlesResponse
}
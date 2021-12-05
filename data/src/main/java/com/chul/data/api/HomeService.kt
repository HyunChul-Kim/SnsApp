package com.chul.data.api

import com.chul.data.model.CardResponse
import com.chul.data.model.HomeResponse
import retrofit2.http.GET

interface HomeService {

    @GET("home")
    suspend fun getHome(): HomeResponse
}
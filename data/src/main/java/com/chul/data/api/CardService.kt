package com.chul.data.api

import com.chul.data.model.CardDetailResponse
import com.chul.data.model.CardResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CardService {

    @GET("cards")
    suspend fun getFeed(): CardResponse

    @GET("cards/{id}")
    suspend fun getPhotoDetail(@Path("id") id: Int): CardDetailResponse
}
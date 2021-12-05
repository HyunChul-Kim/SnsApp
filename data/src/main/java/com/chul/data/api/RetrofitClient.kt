package com.chul.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("http://3.34.129.166:8087/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(OkHttpClient.Builder().build())
    .build()
}
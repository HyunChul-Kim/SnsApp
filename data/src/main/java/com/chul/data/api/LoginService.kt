package com.chul.data.api

import com.chul.data.model.remote.LoginRequest
import com.chul.data.model.remote.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("users/sign_in")
    suspend fun getLoginResponse(@Body request: LoginRequest): LoginResponse
}
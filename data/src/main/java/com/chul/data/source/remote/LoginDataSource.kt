package com.chul.data.source.remote

import com.chul.data.model.remote.LoginRequest
import com.chul.data.model.remote.LoginResponse

interface LoginDataSource {
    suspend fun getLoginResponse(request: LoginRequest): LoginResponse
}
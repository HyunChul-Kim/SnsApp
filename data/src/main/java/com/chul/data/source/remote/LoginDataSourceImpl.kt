package com.chul.data.source.remote

import com.chul.data.api.LoginService
import com.chul.data.model.remote.LoginRequest
import com.chul.data.model.remote.LoginResponse

class LoginDataSourceImpl(
    private val api: LoginService
): LoginDataSource {
    override suspend fun getLoginResponse(request: LoginRequest): LoginResponse {
        return api.getLoginResponse(request)
    }
}
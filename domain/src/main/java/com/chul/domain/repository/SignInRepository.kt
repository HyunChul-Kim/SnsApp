package com.chul.domain.repository

import com.chul.domain.model.Login
import com.chul.domain.model.User

interface SignInRepository {

    suspend fun getLoginResponse(id: String, pwd: String): Login

    suspend fun getUser(): User?

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)
}
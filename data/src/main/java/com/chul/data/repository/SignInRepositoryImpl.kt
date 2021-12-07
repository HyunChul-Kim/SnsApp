package com.chul.data.repository

import com.chul.data.model.local.UserEntity
import com.chul.data.model.local.toDomain
import com.chul.data.model.remote.LoginRequest
import com.chul.data.model.remote.toDomain
import com.chul.data.source.local.UserDataSource
import com.chul.data.source.remote.LoginDataSource
import com.chul.domain.model.Login
import com.chul.domain.model.User
import com.chul.domain.repository.SignInRepository

class SignInRepositoryImpl(
    private val loginDataSource: LoginDataSource,
    private val userDataSource: UserDataSource
): SignInRepository {

    override suspend fun getLoginResponse(id: String, pwd: String): Login {
        val request = LoginRequest(id, pwd)
        return loginDataSource.getLoginResponse(request).toDomain()
    }

    override suspend fun getUser(): User? {
        val users = userDataSource.getUser()
        return if(users.isNullOrEmpty()) {
            null
        } else {
            val user = users[0]
            user.toDomain()
        }
    }

    override suspend fun insertUser(user: User) {
        val userEntity = UserEntity(user.id)
        userDataSource.insertUser(userEntity)
    }

    override suspend fun deleteUser(user: User) {
        val userEntity = UserEntity(user.id)
        userDataSource.deleteUser(userEntity)
    }
}
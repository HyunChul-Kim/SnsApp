package com.chul.data.source.local

import com.chul.data.model.local.UserEntity

interface UserDataSource {
    suspend fun getUser(): List<UserEntity>
    suspend fun insertUser(user: UserEntity)
    suspend fun deleteUser(user: UserEntity)
}
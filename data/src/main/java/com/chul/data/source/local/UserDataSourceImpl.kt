package com.chul.data.source.local

import com.chul.data.db.UserDao
import com.chul.data.model.local.UserEntity

class UserDataSourceImpl(
    private val userDao: UserDao
): UserDataSource {
    override suspend fun getUser(): List<UserEntity> {
        return userDao.getAll()
    }

    override suspend fun insertUser(user: UserEntity) {
        userDao.insert(user)
    }

    override suspend fun deleteUser(user: UserEntity) {
        userDao.delete(user)
    }
}
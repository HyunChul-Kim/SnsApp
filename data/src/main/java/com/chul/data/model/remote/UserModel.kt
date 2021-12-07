package com.chul.data.model.remote

import com.chul.domain.model.User

data class UserModel(
    val nickname: String,
    val introduction: String,
    val id: Int
)

fun UserModel.toDomain() = User(nickname, introduction, id)
fun List<UserModel>.toDomain() = map { it.toDomain() }

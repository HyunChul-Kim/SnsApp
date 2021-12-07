package com.chul.domain.model

data class Login(
    val isLogin: Boolean,
    val errorMsg: String,
    val userId: Int
)
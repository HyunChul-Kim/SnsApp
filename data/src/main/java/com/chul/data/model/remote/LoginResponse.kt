package com.chul.data.model.remote

import com.chul.domain.model.Login
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val ok: Boolean,
    @SerializedName("error_msg") val errorMsg: String?,
    @SerializedName("user_id") val userId: Int
)

fun LoginResponse.toDomain() = Login(ok, errorMsg ?: "", userId)
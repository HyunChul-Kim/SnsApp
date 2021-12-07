package com.chul.domain.usecase

import com.chul.domain.model.Login
import com.chul.domain.repository.SignInRepository

class GetSignInUseCase(
    private val repository: SignInRepository
) {

    suspend fun invoke(id: String, pwd: String): Login {
        return repository.getLoginResponse(id, pwd)
    }
}
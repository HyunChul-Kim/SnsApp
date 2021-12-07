package com.chul.domain.usecase

import com.chul.domain.model.User
import com.chul.domain.repository.SignInRepository

class GetSignedUserUseCase(
    private val signInRepository: SignInRepository
) {
    suspend fun invoke(): User? {
        return signInRepository.getUser()
    }
}
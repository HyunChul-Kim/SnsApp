package com.chul.domain.usecase

import com.chul.domain.model.User
import com.chul.domain.repository.SignInRepository

class GetInsertUserUseCase(
    private val signInRepository: SignInRepository
) {
    suspend fun invoke(user: User) {
        signInRepository.insertUser(user)
    }
}
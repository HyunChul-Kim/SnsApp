package com.chul.domain.usecase

import com.chul.domain.model.User
import com.chul.domain.repository.SignInRepository

class GetSignOutUseCase(
    private val repository: SignInRepository
) {

    suspend fun invoke(user: User) {
        repository.deleteUser(user)
    }
}
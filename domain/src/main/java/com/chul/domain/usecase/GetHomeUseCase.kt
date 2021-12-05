package com.chul.domain.usecase

import com.chul.domain.model.Home
import com.chul.domain.repository.HomeRepository

class GetHomeUseCase(private val repository: HomeRepository) {
    suspend fun invoke(): Home {
        return repository.getHome()
    }
}
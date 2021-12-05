package com.chul.domain.usecase

import com.chul.domain.model.PhotoFeed
import com.chul.domain.repository.CardRepository

class GetPhotoFeedUseCase(
    private val repository: CardRepository
) {
    suspend fun invoke(): PhotoFeed {
        return repository.getPhotoFeed()
    }
}
package com.chul.domain.usecase

import com.chul.domain.model.PhotoDetail
import com.chul.domain.repository.CardRepository

class GetPhotoDetailUseCase(
    private val repository: CardRepository
) {
    suspend fun invoke(id: Int): PhotoDetail {
        return repository.getPhotoDetail(id)
    }
}
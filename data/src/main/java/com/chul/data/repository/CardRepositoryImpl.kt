package com.chul.data.repository

import com.chul.data.model.toDomain
import com.chul.data.source.card.CardDataSource
import com.chul.domain.model.PhotoDetail
import com.chul.domain.model.PhotoFeed
import com.chul.domain.repository.CardRepository

class CardRepositoryImpl(
    private val cardDataSource: CardDataSource
): CardRepository {
    override suspend fun getPhotoFeed(id: Int, per: Int): PhotoFeed {
        return cardDataSource.getPhotoFeed(id, per).toDomain()
    }

    override suspend fun getPhotoDetail(id: Int): PhotoDetail {
        return cardDataSource.getPhotoDetail(id).toDomain()
    }
}
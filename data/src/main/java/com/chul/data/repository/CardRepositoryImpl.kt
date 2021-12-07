package com.chul.data.repository

import com.chul.data.model.remote.toDomain
import com.chul.data.source.remote.card.CardDataSource
import com.chul.domain.model.Card
import com.chul.domain.model.PhotoDetail
import com.chul.domain.model.PhotoFeed
import com.chul.domain.model.User
import com.chul.domain.repository.CardRepository

class CardRepositoryImpl(
    private val cardDataSource: CardDataSource
): CardRepository {
    override suspend fun getPhotoFeed(id: Int, per: Int): PhotoFeed {
        return try {
            cardDataSource.getPhotoFeed(id, per).toDomain()
        } catch (e: Exception) {
            PhotoFeed(emptyList())
        }
    }

    override suspend fun getPhotoDetail(id: Int): PhotoDetail {
        return try {
            cardDataSource.getPhotoDetail(id).toDomain()
        } catch (e: Exception) {
            PhotoDetail(Card(0, "", "", 0), User("", "", 0), emptyList())
        }
    }
}
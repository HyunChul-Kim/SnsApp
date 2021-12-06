package com.chul.data.source.card

import com.chul.data.api.CardService
import com.chul.data.api.HomeService
import com.chul.data.model.CardDetailResponse
import com.chul.data.model.CardResponse

class CardDataSourceImpl(private val api: CardService): CardDataSource {
    override suspend fun getPhotoFeed(id: Int, per: Int): CardResponse {
        return api.getFeed(id, per)
    }

    override suspend fun getPhotoDetail(id: Int): CardDetailResponse {
        return api.getPhotoDetail(id)
    }
}
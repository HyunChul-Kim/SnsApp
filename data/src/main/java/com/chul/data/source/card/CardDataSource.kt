package com.chul.data.source.card

import com.chul.data.model.CardDetailResponse
import com.chul.data.model.CardResponse

interface CardDataSource {

    suspend fun getPhotoFeed(id: Int, per: Int): CardResponse

    suspend fun getPhotoDetail(id: Int): CardDetailResponse
}
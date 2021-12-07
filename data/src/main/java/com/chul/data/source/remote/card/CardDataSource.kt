package com.chul.data.source.remote.card

import com.chul.data.model.remote.CardDetailResponse
import com.chul.data.model.remote.CardResponse

interface CardDataSource {

    suspend fun getPhotoFeed(id: Int, per: Int): CardResponse

    suspend fun getPhotoDetail(id: Int): CardDetailResponse
}
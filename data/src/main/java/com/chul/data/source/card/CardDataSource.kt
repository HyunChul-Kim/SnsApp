package com.chul.data.source.card

import com.chul.data.model.CardDetailResponse
import com.chul.data.model.CardResponse

interface CardDataSource {

    suspend fun getPhotoFeed(): CardResponse

    suspend fun getPhotoDetail(id: Int): CardDetailResponse
}
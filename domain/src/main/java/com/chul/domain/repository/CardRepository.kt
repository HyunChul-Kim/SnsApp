package com.chul.domain.repository

import com.chul.domain.model.PhotoDetail
import com.chul.domain.model.PhotoFeed

interface CardRepository {
    suspend fun getPhotoFeed(): PhotoFeed
    suspend fun getPhotoDetail(id: Int): PhotoDetail
}
package com.chul.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.chul.data.api.CardService
import com.chul.data.source.remote.card.CardPagingSource
import com.chul.domain.model.Card
import kotlinx.coroutines.flow.Flow

class CardPagingRepository(
    private val cardPagingSource: CardPagingSource
) {
    fun getCards(): Flow<PagingData<Card>> {
        return Pager(PagingConfig(pageSize = 20)) {
            cardPagingSource
        }.flow
    }
}
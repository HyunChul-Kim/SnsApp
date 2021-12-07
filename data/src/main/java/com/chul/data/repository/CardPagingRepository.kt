package com.chul.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.chul.data.api.CardService
import com.chul.data.source.remote.card.CardPagingSource
import com.chul.domain.model.Card
import kotlinx.coroutines.flow.Flow

class CardPagingRepository(
    private val api: CardService
) {
    fun getCards(): LiveData<PagingData<Card>> {
        return Pager(PagingConfig(pageSize = 20)) {
            CardPagingSource(api)
        }.liveData
    }
}
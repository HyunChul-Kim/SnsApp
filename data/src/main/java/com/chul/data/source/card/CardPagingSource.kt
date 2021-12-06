package com.chul.data.source.card

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.chul.data.api.CardService
import com.chul.data.model.toDomain
import com.chul.domain.model.Card

class CardPagingSource constructor(
    private val api: CardService
): PagingSource<Int, Card>() {
    override fun getRefreshKey(state: PagingState<Int, Card>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Card> {
        return try {
            val next = params.key ?: 1
            val response = api.getFeed(next, 20)
            if(response.ok) {
                val cards = response.cards.toDomain()
                LoadResult.Page(
                    data = cards,
                    prevKey = if(next == 1) null else next - 1,
                    nextKey = next + 1
                )
            } else {
                LoadResult.Error(Exception(""))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
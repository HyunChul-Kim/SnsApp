package com.chul.data.model

import com.chul.domain.model.PhotoFeed

data class CardResponse(
    val ok: Boolean,
    val cards: List<CardModel>
)

fun CardResponse.toDomain() = PhotoFeed(cards.toDomain())
package com.chul.data.model

import com.chul.domain.model.PhotoDetail
import com.google.gson.annotations.SerializedName

data class CardDetailResponse(
    val card: CardModel,
    val user: UserModel,
    @SerializedName("recommend_cards") val recommendCards: List<CardModel>
)

fun CardDetailResponse.toDomain() = PhotoDetail(card.toDomain(), user.toDomain(), recommendCards.toDomain())

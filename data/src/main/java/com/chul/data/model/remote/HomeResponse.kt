package com.chul.data.model.remote

import com.chul.domain.model.Home
import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("popular_cards") val popularCards: List<CardModel>,
    @SerializedName("popular_users") val popularUsers: List<UserModel>,
    val ok: Boolean
)

fun HomeResponse.toDomain() = Home(popularCards.toDomain(), popularUsers.toDomain())
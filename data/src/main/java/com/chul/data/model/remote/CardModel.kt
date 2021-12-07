package com.chul.data.model.remote

import com.chul.domain.model.Card
import com.google.gson.annotations.SerializedName

data class CardModel(
    @SerializedName("user_id") val userId: Int,
    @SerializedName("img_url") val imageUrl: String,
    val description: String,
    val id: Int
)

fun CardModel.toDomain() = Card(userId, imageUrl, description, id)
fun List<CardModel>.toDomain() = map { it.toDomain() }
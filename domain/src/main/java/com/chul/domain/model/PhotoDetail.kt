package com.chul.domain.model

data class PhotoDetail(
    val card: Card,
    val user: User,
    val recommendCards: List<Card>
)

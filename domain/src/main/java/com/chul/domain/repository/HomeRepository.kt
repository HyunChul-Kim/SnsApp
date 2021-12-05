package com.chul.domain.repository

import com.chul.domain.model.Home

interface HomeRepository {

    suspend fun getHome(): Home
}
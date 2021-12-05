package com.chul.data.source.home

import com.chul.data.model.HomeResponse

interface HomeDataSource {
    suspend fun getHome(): HomeResponse
}
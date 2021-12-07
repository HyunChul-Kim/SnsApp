package com.chul.data.source.remote.home

import com.chul.data.model.remote.HomeResponse

interface HomeDataSource {
    suspend fun getHome(): HomeResponse
}
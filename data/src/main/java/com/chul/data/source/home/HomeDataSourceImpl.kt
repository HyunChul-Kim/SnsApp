package com.chul.data.source.home

import com.chul.data.api.HomeService
import com.chul.data.model.HomeResponse

class HomeDataSourceImpl(private val api: HomeService): HomeDataSource {

    override suspend fun getHome(): HomeResponse {
        return api.getHome()
    }
}
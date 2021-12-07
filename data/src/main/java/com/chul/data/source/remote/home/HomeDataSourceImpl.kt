package com.chul.data.source.remote.home

import com.chul.data.api.HomeService
import com.chul.data.model.remote.HomeResponse

class HomeDataSourceImpl(private val api: HomeService): HomeDataSource {

    override suspend fun getHome(): HomeResponse {
        return api.getHome()
    }
}
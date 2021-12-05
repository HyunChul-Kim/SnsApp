package com.chul.data.repository

import com.chul.data.model.toDomain
import com.chul.data.source.home.HomeDataSource
import com.chul.domain.model.Home
import com.chul.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val homeDataSource: HomeDataSource
): HomeRepository {
    override suspend fun getHome(): Home {
        return homeDataSource.getHome().toDomain()
    }
}
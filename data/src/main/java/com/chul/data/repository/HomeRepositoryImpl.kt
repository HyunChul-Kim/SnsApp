package com.chul.data.repository

import com.chul.data.model.remote.toDomain
import com.chul.data.source.remote.home.HomeDataSource
import com.chul.domain.model.Home
import com.chul.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val homeDataSource: HomeDataSource
): HomeRepository {
    override suspend fun getHome(): Home {
        return try {
            homeDataSource.getHome().toDomain()
        } catch (e: Exception) {
            Home(emptyList(), emptyList())
        }
    }
}
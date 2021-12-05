package com.chul.presentation.di.module

import com.chul.data.repository.CardRepositoryImpl
import com.chul.data.repository.HomeRepositoryImpl
import com.chul.data.source.card.CardDataSource
import com.chul.data.source.home.HomeDataSource
import com.chul.domain.repository.CardRepository
import com.chul.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideHomeRepository(dataSource: HomeDataSource): HomeRepository {
        return HomeRepositoryImpl(dataSource)
    }

    @Singleton
    @Provides
    fun provideCardRepository(dataSource: CardDataSource): CardRepository {
        return CardRepositoryImpl(dataSource)
    }
}
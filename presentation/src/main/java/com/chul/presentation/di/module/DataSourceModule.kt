package com.chul.presentation.di.module

import com.chul.data.api.CardService
import com.chul.data.api.HomeService
import com.chul.data.source.card.CardDataSource
import com.chul.data.source.card.CardDataSourceImpl
import com.chul.data.source.home.HomeDataSource
import com.chul.data.source.home.HomeDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {
    @Singleton
    @Provides
    fun provideHomeDataSource(api: HomeService): HomeDataSource {
        return HomeDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun provideCardDataSource(api: CardService): CardDataSource {
        return CardDataSourceImpl(api)
    }
}
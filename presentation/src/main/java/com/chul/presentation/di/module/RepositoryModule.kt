package com.chul.presentation.di.module

import com.chul.data.api.CardService
import com.chul.data.repository.CardPagingRepository
import com.chul.data.repository.CardRepositoryImpl
import com.chul.data.repository.HomeRepositoryImpl
import com.chul.data.repository.SignInRepositoryImpl
import com.chul.data.source.local.UserDataSource
import com.chul.data.source.remote.LoginDataSource
import com.chul.data.source.remote.card.CardDataSource
import com.chul.data.source.remote.card.CardPagingSource
import com.chul.data.source.remote.home.HomeDataSource
import com.chul.domain.repository.CardRepository
import com.chul.domain.repository.HomeRepository
import com.chul.domain.repository.SignInRepository
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

    @Provides
    fun provideCardPagingRepository(api: CardService): CardPagingRepository {
        return CardPagingRepository(api)
    }

    @Provides
    fun provideLoginRepository(dataSource: LoginDataSource, userDataSource: UserDataSource): SignInRepository {
        return SignInRepositoryImpl(dataSource, userDataSource)
    }
}
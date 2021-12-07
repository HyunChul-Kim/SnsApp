package com.chul.presentation.di.module

import com.chul.data.api.CardService
import com.chul.data.api.HomeService
import com.chul.data.api.LoginService
import com.chul.data.db.UserDao
import com.chul.data.source.local.UserDataSource
import com.chul.data.source.local.UserDataSourceImpl
import com.chul.data.source.remote.LoginDataSource
import com.chul.data.source.remote.LoginDataSourceImpl
import com.chul.data.source.remote.card.CardDataSource
import com.chul.data.source.remote.card.CardDataSourceImpl
import com.chul.data.source.remote.card.CardPagingSource
import com.chul.data.source.remote.home.HomeDataSource
import com.chul.data.source.remote.home.HomeDataSourceImpl
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

    @Provides
    fun provideLoginDataSource(api: LoginService): LoginDataSource {
        return LoginDataSourceImpl(api)
    }

    @Provides
    fun provideUserDataSource(userDao: UserDao): UserDataSource {
        return UserDataSourceImpl(userDao)
    }
}
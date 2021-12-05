package com.chul.presentation.di.module

import com.chul.data.api.CardService
import com.chul.data.api.RetrofitClient
import com.chul.data.api.HomeService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return RetrofitClient.retrofit
    }

    @Singleton
    @Provides
    fun provideHomeService(retrofit: Retrofit): HomeService {
        return retrofit.create(HomeService::class.java)
    }

    @Singleton
    @Provides
    fun provideCardService(retrofit: Retrofit): CardService {
        return retrofit.create(CardService::class.java)
    }
}
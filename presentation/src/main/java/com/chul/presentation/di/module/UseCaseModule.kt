package com.chul.presentation.di.module

import com.chul.domain.repository.CardRepository
import com.chul.domain.repository.HomeRepository
import com.chul.domain.usecase.GetHomeUseCase
import com.chul.domain.usecase.GetPhotoDetailUseCase
import com.chul.domain.usecase.GetPhotoFeedUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetHomeUseCase(repository: HomeRepository): GetHomeUseCase {
        return GetHomeUseCase(repository)
    }

    @Provides
    fun provideGetPhotoFeedUseCase(repository: CardRepository): GetPhotoFeedUseCase {
        return GetPhotoFeedUseCase(repository)
    }

    @Provides
    fun provideGetPhotoDetailUseCase(repository: CardRepository): GetPhotoDetailUseCase {
        return GetPhotoDetailUseCase(repository)
    }
}
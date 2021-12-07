package com.chul.presentation.di.module

import com.chul.domain.repository.CardRepository
import com.chul.domain.repository.HomeRepository
import com.chul.domain.repository.SignInRepository
import com.chul.domain.usecase.*
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

    @Provides
    fun provideGetSignInUseCase(repository: SignInRepository): GetSignInUseCase {
        return GetSignInUseCase(repository)
    }

    @Provides
    fun provideGetSignedUserUseCase(repository: SignInRepository): GetSignedUserUseCase {
        return GetSignedUserUseCase(repository)
    }

    @Provides
    fun provideGetInsertUserUseCase(repository: SignInRepository): GetInsertUserUseCase {
        return GetInsertUserUseCase(repository)
    }

    @Provides
    fun provideGetSignOutUseCase(repository: SignInRepository): GetSignOutUseCase {
        return GetSignOutUseCase(repository)
    }
}
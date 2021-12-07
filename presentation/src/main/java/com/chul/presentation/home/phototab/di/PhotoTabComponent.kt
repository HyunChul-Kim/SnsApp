package com.chul.presentation.home.phototab.di

import com.chul.data.api.CardService
import com.chul.data.repository.CardPagingRepository
import com.chul.presentation.di.scope.SubFragmentScope
import com.chul.presentation.home.phototab.PhotoTabFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@SubFragmentScope
@Subcomponent(modules = [
    PhotoTabModule::class
])
interface PhotoTabComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PhotoTabComponent
    }

    fun inject(photoTabFragment: PhotoTabFragment)
}
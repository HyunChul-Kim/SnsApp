package com.chul.presentation.home.di

import com.chul.data.api.CardService
import com.chul.data.repository.CardPagingRepository
import com.chul.presentation.di.scope.FragmentScope
import com.chul.presentation.di.scope.SubFragmentScope
import com.chul.presentation.home.HomeFragment
import com.chul.presentation.home.hometab.di.HomeTabComponent
import com.chul.presentation.home.hometab.di.HomeTabModule
import com.chul.presentation.home.phototab.di.PhotoTabComponent
import com.chul.presentation.home.phototab.di.PhotoTabModule
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [
    HomeModule::class
])
interface HomeComponent {

    @Subcomponent.Factory
    interface  Factory {
        fun create(): HomeComponent
    }

    fun inject(fragment: HomeFragment)

    fun homeTabComponent(): HomeTabComponent.Factory
    fun photoTabComponent(): PhotoTabComponent.Factory
}
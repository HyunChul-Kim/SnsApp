package com.chul.presentation.home.di

import com.chul.presentation.di.scope.FragmentScope
import com.chul.presentation.home.HomeFragment
import com.chul.presentation.home.hometab.di.HomeTabComponent
import com.chul.presentation.home.hometab.di.HomeTabModule
import com.chul.presentation.home.phototab.di.PhotoTabComponent
import com.chul.presentation.home.phototab.di.PhotoTabModule
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [
    HomeModule::class,
    HomeTabModule::class,
    PhotoTabModule::class
])
interface HomeComponent {

    @Subcomponent.Factory
    interface  Factory {
        fun create(): HomeComponent
    }

    fun inject(homeFragment: HomeFragment)

    fun homeTabComponent(): HomeTabComponent.Factory
    fun photoTabComponent(): PhotoTabComponent.Factory
}
package com.chul.presentation.home.hometab.di

import com.chul.presentation.di.scope.FragmentScope
import com.chul.presentation.home.hometab.HomeTabFragment
import dagger.Subcomponent

@Subcomponent(modules = [HomeTabModule::class])
interface HomeTabComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeTabComponent
    }

    fun inject(homeTabFragment: HomeTabFragment)
}
package com.chul.presentation.home.di

import androidx.lifecycle.ViewModel
import com.chul.presentation.home.HomeViewModel
import com.chul.presentation.home.hometab.di.HomeTabComponent
import com.chul.presentation.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(subcomponents = [
    HomeTabComponent::class
])
abstract class HomeModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}
package com.chul.presentation.home.di

import androidx.lifecycle.ViewModel
import com.chul.presentation.di.scope.FragmentScope
import com.chul.presentation.home.HomeViewModel
import com.chul.presentation.home.hometab.di.HomeTabComponent
import com.chul.presentation.home.phototab.di.PhotoTabComponent
import com.chul.presentation.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(subcomponents = [
    HomeTabComponent::class,
    PhotoTabComponent::class
])
abstract class HomeModule {
    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}
package com.chul.presentation.home.hometab.di

import androidx.lifecycle.ViewModel
import com.chul.presentation.di.scope.FragmentScope
import com.chul.presentation.di.scope.SubFragmentScope
import com.chul.presentation.home.hometab.HomeTabViewModel
import com.chul.presentation.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeTabModule {
    @SubFragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(HomeTabViewModel::class)
    abstract fun bindHomeTabViewModel(viewModel: HomeTabViewModel): ViewModel
}
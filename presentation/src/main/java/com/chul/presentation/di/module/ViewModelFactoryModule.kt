package com.chul.presentation.di.module

import androidx.lifecycle.ViewModelProvider
import com.chul.presentation.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
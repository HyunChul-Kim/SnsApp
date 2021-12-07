package com.chul.presentation.main.di

import androidx.lifecycle.ViewModel
import com.chul.presentation.home.di.HomeComponent
import com.chul.presentation.main.MainViewModel
import com.chul.presentation.photodetail.di.PhotoDetailComponent
import com.chul.presentation.signin.di.SignInComponent
import com.chul.presentation.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(subcomponents = [
    HomeComponent::class,
    PhotoDetailComponent::class,
    SignInComponent::class
])
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
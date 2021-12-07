package com.chul.presentation.signin.di

import androidx.lifecycle.ViewModel
import com.chul.presentation.signin.SignInViewModel
import com.chul.presentation.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SignInModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    abstract fun bindSignInViewModel(viewModel: SignInViewModel): ViewModel
}
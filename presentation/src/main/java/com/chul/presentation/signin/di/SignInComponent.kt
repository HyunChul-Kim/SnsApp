package com.chul.presentation.signin.di

import com.chul.presentation.di.scope.FragmentScope
import com.chul.presentation.signin.SignInFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [
    SignInModule::class
])
interface SignInComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SignInComponent
    }

    fun inject(fragment: SignInFragment)
}
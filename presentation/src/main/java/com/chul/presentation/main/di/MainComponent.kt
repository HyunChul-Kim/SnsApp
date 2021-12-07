package com.chul.presentation.main.di

import com.chul.presentation.di.scope.ActivityScope
import com.chul.presentation.home.di.HomeComponent
import com.chul.presentation.main.MainActivity
import com.chul.presentation.photodetail.di.PhotoDetailComponent
import com.chul.presentation.signin.di.SignInComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [
    MainModule::class
])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)

    fun homeComponent(): HomeComponent.Factory
    fun photoDetailComponent(): PhotoDetailComponent.Factory
    fun signInComponent(): SignInComponent.Factory
}
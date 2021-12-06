package com.chul.presentation.main.di

import com.chul.presentation.home.di.HomeComponent
import com.chul.presentation.main.MainActivity
import com.chul.presentation.photodetail.di.PhotoDetailComponent
import dagger.Subcomponent

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
}
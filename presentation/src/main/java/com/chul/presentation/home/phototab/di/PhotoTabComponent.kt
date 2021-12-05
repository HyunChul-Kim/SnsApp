package com.chul.presentation.home.phototab.di

import com.chul.presentation.di.scope.FragmentScope
import com.chul.presentation.home.phototab.PhotoTabFragment
import dagger.Subcomponent

@Subcomponent(modules = [PhotoTabModule::class])
interface PhotoTabComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PhotoTabComponent
    }

    fun inject(photoTabFragment: PhotoTabFragment)
}
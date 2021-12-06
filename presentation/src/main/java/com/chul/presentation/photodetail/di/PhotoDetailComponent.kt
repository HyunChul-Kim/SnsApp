package com.chul.presentation.photodetail.di

import com.chul.presentation.di.scope.FragmentScope
import com.chul.presentation.photodetail.PhotoDetailFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [
    PhotoDetailModule::class
])
interface PhotoDetailComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PhotoDetailComponent
    }

    fun inject(fragment: PhotoDetailFragment)
}
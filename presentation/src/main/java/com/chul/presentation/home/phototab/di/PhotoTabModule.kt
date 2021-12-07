package com.chul.presentation.home.phototab.di

import androidx.lifecycle.ViewModel
import com.chul.presentation.di.scope.SubFragmentScope
import com.chul.presentation.home.phototab.PhotoTabViewModel
import com.chul.presentation.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PhotoTabModule {

    @SubFragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(PhotoTabViewModel::class)
    abstract fun bindPhotoTabViewModel(viewModel: PhotoTabViewModel): ViewModel
}
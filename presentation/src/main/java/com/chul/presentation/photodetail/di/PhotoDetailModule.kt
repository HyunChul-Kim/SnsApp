package com.chul.presentation.photodetail.di

import androidx.lifecycle.ViewModel
import com.chul.presentation.photodetail.PhotoDetailViewModel
import com.chul.presentation.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PhotoDetailModule {

    @Binds
    @IntoMap
    @ViewModelKey(PhotoDetailViewModel::class)
    abstract fun bindPhotoDetailViewModel(viewModel: PhotoDetailViewModel): ViewModel
}
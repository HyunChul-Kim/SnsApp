package com.chul.presentation.main.di

import com.chul.presentation.home.di.HomeComponent
import com.chul.presentation.photodetail.di.PhotoDetailComponent
import dagger.Module

@Module(subcomponents = [
    HomeComponent::class,
    PhotoDetailComponent::class
])
class MainModule
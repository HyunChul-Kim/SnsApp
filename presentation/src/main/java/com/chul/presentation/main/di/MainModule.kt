package com.chul.presentation.main.di

import com.chul.presentation.home.di.HomeComponent
import dagger.Module

@Module(subcomponents = [
    HomeComponent::class
])
class MainModule
package com.chul.presentation.di.module

import com.chul.presentation.main.di.MainComponent
import dagger.Module

@Module(subcomponents = [
    MainComponent::class
])
class SubComponentModule
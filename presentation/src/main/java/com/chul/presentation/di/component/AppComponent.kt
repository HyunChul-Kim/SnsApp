package com.chul.presentation.di.component

import android.content.Context
import com.chul.presentation.di.module.*
import com.chul.presentation.main.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    ViewModelFactoryModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    DataSourceModule::class,
    SubComponentModule::class
])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun mainComponent(): MainComponent.Factory
}
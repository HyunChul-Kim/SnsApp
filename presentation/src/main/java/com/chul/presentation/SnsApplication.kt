package com.chul.presentation

import android.app.Application
import com.chul.presentation.di.component.AppComponent
import com.chul.presentation.di.component.DaggerAppComponent

class SnsApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}
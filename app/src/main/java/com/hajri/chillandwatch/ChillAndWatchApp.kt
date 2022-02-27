package com.hajri.chillandwatch

import android.app.Application
import com.hajri.chillandwatch.di.appComponents
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin

class ChillAndWatchApp : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ChillAndWatchApp)
            modules(appComponents)
        }
    }
}
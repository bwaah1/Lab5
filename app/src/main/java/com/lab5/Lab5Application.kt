package com.lab5

import android.app.Application
import com.lab5.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Lab5Application : Application() {
    override fun onCreate() {
        super.onCreate()

        // Ініціалізація
        startKoin {
            // Передаємо контекст Android
            androidContext(this@Lab5Application)
            // модулі Koin
            modules(appModule)
        }
    }
}

package com.intive.androidplayground

import androidx.multidex.MultiDexApplication
import com.intive.androidplayground.di.matchModule
import com.intive.androidplayground.di.networkApiModule
import com.intive.androidplayground.di.womenWorldCupModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PlaygroundApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@PlaygroundApplication)
            modules(listOf(networkApiModule, womenWorldCupModule, matchModule))
        }
    }
}
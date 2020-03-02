package com.intive.androidplayground.di

import okhttp3.OkHttpClient
import org.koin.dsl.module

val networkApiModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

}
package com.intive.androidplayground.di

import com.intive.androidplayground.api.WomenWorldCupAPI
import com.intive.androidplayground.api.WomenWorldCupAPIFactory
import org.koin.dsl.module
import retrofit2.Retrofit

val womenWorldCupModule = module {

    single {
        WomenWorldCupAPIFactory(get()).buildRetrofitClient()
    }

    single {
        get<Retrofit>().create(WomenWorldCupAPI::class.java)
    }
}
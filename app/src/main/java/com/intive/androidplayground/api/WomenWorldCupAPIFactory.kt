package com.intive.androidplayground.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val URL = "https://worldcup.sfg.io/"

class WomenWorldCupAPIFactory(private val httpClient: OkHttpClient) {

    fun buildRetrofitClient(): Retrofit = Retrofit.Builder()
        .callFactory(httpClient)
        .baseUrl(URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}
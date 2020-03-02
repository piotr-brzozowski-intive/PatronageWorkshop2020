package com.intive.androidplayground.api

import com.intive.androidplayground.match.model.MatchResult
import io.reactivex.Single
import retrofit2.http.GET

interface WomenWorldCupAPI {

    @GET("/teams/results")
    fun getTeamsResult(): Single<List<MatchResult>>
}
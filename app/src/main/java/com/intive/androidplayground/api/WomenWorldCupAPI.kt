package com.intive.androidplayground.api

import com.intive.androidplayground.match.model.Match
import com.intive.androidplayground.match.model.MatchResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WomenWorldCupAPI {

    @GET("/teams/results")
    fun getTeamsResult(): Single<List<MatchResult>>

    @GET("/matches/country")
    fun getMatchesByCountry(@Query("fifa_code") fifaCode: String): Single<List<Match>>
}
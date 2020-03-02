package com.intive.androidplayground.match.model.api.repository

import com.intive.androidplayground.match.model.MatchResult
import io.reactivex.Single

interface MatchResultRepositoryAPI {

    fun getMatchResults(): Single<List<MatchResult>>

    fun setMatchResults(matchResults: List<MatchResult>)
}
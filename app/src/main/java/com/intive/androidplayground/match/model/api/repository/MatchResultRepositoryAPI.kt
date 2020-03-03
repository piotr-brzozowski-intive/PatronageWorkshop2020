package com.intive.androidplayground.match.model.api.repository

import com.intive.androidplayground.match.model.MatchResult
import io.reactivex.Maybe
import io.reactivex.Single

interface MatchResultRepositoryAPI {

    fun getMatchResults(): Maybe<List<MatchResult>>

    fun setMatchResults(matchResults: List<MatchResult>)
}
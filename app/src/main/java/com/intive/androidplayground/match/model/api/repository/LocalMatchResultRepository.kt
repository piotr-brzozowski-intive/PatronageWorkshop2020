package com.intive.androidplayground.match.model.api.repository

import com.intive.androidplayground.match.model.MatchResult
import io.reactivex.Maybe

class LocalMatchResultRepository :
    MatchResultRepositoryAPI {

    private val matchResults = mutableListOf<MatchResult>()

    override fun getMatchResults(): Maybe<List<MatchResult>> = Maybe.just(matchResults)
        .map { it.toList() }
        .filter { it.isNotEmpty() }

    override fun setMatchResults(matchResults: List<MatchResult>) {
        this.matchResults.clear()
        this.matchResults.addAll(matchResults)
    }
}
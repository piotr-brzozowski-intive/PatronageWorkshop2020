package com.intive.androidplayground.match.model.api.repository

import com.intive.androidplayground.match.model.MatchResult
import io.reactivex.Single

class LocalMatchResultRepository :
    MatchResultRepositoryAPI {

    private val matchResults = mutableListOf<MatchResult>()

    override fun getMatchResults(): Single<List<MatchResult>> = if (matchResults.isNotEmpty()) {
        Single.just(matchResults)
    } else {
        Single.error<List<MatchResult>> {
            NoSuchElementException("no local item exists!")
        }
    }

    override fun setMatchResults(matchResults: List<MatchResult>) {
        this.matchResults.clear()
        this.matchResults.addAll(matchResults)
    }
}
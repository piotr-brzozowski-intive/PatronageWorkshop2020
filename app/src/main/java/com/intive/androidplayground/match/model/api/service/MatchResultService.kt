package com.intive.androidplayground.match.model.api.service

import com.intive.androidplayground.api.WomenWorldCupAPI
import com.intive.androidplayground.match.model.MatchResult
import com.intive.androidplayground.match.model.api.repository.MatchResultRepositoryAPI
import io.reactivex.Maybe
import io.reactivex.Single

class MatchResultService(
    private val womenWorldCupAPI: WomenWorldCupAPI,
    private val matchRepository: MatchResultRepositoryAPI
) {


    fun fetchMatchResults(): Single<List<MatchResult>> = matchRepository.getMatchResults()
        .switchIfEmpty (fetchMatchesFromNetwork())

    private fun fetchMatchesFromNetwork(): Single<List<MatchResult>> {
        return womenWorldCupAPI.getTeamsResult().doOnSuccess {
            matchRepository.setMatchResults(it)
        }
    }
}
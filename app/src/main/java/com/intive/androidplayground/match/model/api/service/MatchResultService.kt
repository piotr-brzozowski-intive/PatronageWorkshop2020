package com.intive.androidplayground.match.model.api.service

import com.intive.androidplayground.api.WomenWorldCupAPI
import com.intive.androidplayground.match.model.MatchResult
import com.intive.androidplayground.match.model.api.repository.MatchResultRepositoryAPI
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class MatchResultService(
    private val womenWorldCupAPI: WomenWorldCupAPI,
    private val matchRepository: MatchResultRepositoryAPI
) {


    fun fetchMatchResults(): Single<List<MatchResult>> = matchRepository.getMatchResults()
        .switchIfEmpty (fetchMatchesFromNetwork())

    fun scheduleFetchMatchesFromNetwork(): Observable<List<MatchResult>> = Observable.interval(5, 10, TimeUnit.SECONDS)
        .flatMap {
            womenWorldCupAPI.getTeamsResult().toObservable()
        }

    fun scheduleWithBeginEmission(): Observable<Long> = Observable.interval(5, 10, TimeUnit.SECONDS)
        .map { Random(it).nextInt(200).toLong() }
        .startWith(Long.MIN_VALUE)

    fun withDelay(): Observable<Long> = Observable.just(0)
        .delay(10L, TimeUnit.SECONDS)
        .map { Random(it).nextInt(200).toLong() }
        .startWith(Long.MIN_VALUE)

    fun withConcat(): Observable<String> = Observable.interval(0, 1, TimeUnit.SECONDS)
        .concatMap{
            Observable.just(
                it.toString().plus("test"))
        }

    fun withSwitch(): Observable<String> = Observable.fromIterable(listOf(10, 20, 30))
        .switchMap{
            Observable.just(
                it.toString().plus("test"))
                .delay(5, TimeUnit.SECONDS)
        }

    private fun fetchMatchesFromNetwork(): Single<List<MatchResult>> {
        return womenWorldCupAPI.getTeamsResult().doOnSuccess {
            matchRepository.setMatchResults(it)
        }
    }
}
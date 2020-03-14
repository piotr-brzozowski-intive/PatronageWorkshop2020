package com.intive.androidplayground.match.model.api.service

import com.intive.androidplayground.api.WomenWorldCupAPI
import com.intive.androidplayground.match.model.Match
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

class MatchService (private val womenWorldCupAPI: WomenWorldCupAPI) {

    fun getMatchesForLatestCountry(): Observable<List<Match>> = Observable.fromIterable(listOf("USA", "JPN", "ARG"))
        .switchMap {
            womenWorldCupAPI.getMatchesByCountry(it).toObservable().delay(5, TimeUnit.SECONDS)
        }

    fun getMatchesForEachCountry(): Observable<List<Match>> = Observable.fromIterable(listOf("USA", "JPN", "ARG"))
        .concatMap {
            womenWorldCupAPI.getMatchesByCountry(it).toObservable().delay(5, TimeUnit.SECONDS)
        }

    fun getMatchesForCountryInInterval(country: String): Observable<List<Match>> = Observable.interval(0, 10, TimeUnit.SECONDS)
        .flatMap {
            womenWorldCupAPI.getMatchesByCountry(country).toObservable()
        }

    fun getMatchesInMinDelay(country: String): Observable<List<Match>> = Observable.zip(
        womenWorldCupAPI.getMatchesByCountry(country).toObservable(),
        Observable.timer(5, TimeUnit.SECONDS),
        BiFunction<List<Match>, Long, List<Match>>{ matches, timeout ->
            matches
        }
    )

    fun getMatchesMerge(c1: String, c2: String): Observable<List<Match>> = Observable.merge(
        womenWorldCupAPI.getMatchesByCountry(c1).toObservable(),
        womenWorldCupAPI.getMatchesByCountry(c2).toObservable()
    )

    fun getMatchesWitchMatchCriteria(c: String): Observable<Match> = womenWorldCupAPI.getMatchesByCountry(c).toObservable()
        .flatMapIterable { it }//List<Match> -> Match, Match, Match....
        //.map { it.attendance.toInt() }
        .filter { it.attendance.toInt() > 20000 }

}
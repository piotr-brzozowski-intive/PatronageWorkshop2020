package com.intive.androidplayground.match.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intive.androidplayground.match.model.MatchResult
import com.intive.androidplayground.match.model.api.service.MatchResultService
import com.intive.androidplayground.match.model.api.service.MatchService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

private const val TAG = "MatchResultViewModel"
class MatchResultViewModel(matchResultService: MatchResultService, matchService: MatchService) : ViewModel() {

    val items = MutableLiveData<List<MatchResult>>()
    val error = MutableLiveData<Boolean>().apply { value = false }
    private var itemsCall: Disposable? = null

    init {
        itemsCall = matchResultService.fetchMatchResults()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.value = it
            }, {
                error.value = true
            })

//        matchService.getMatchesForLatestCountry()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "by country(switch) $it")
//            }, {
//                error.value = true
//            })

//        matchService.getMatchesForEachCountry()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "by country(concat) $it")
//            }, {
//                error.value = true
//            })

//        matchService.getMatchesForCountryInInterval("ARG")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "by country(interval) $it")
//            }, {
//                error.value = true
//            })

//        matchService.getMatchesInMinDelay("ARG")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "by country(zip) $it")
//            }, {
//                error.value = true
//            })

//        matchService.getMatchesMerge("ARG", "USA")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "by country(merge) $it")
//            }, {
//                error.value = true
//            })

        matchService.getMatchesWitchMatchCriteria("ARG")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "by country(filter, map, flatMapIterable) $it")
            }, {
                error.value = true
            })

//        matchResultService.scheduleFetchMatchesFromNetwork()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "schedule $it")
//            }, {
//                error.value = true
//            })

//        matchResultService.scheduleWithBeginEmission()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "schedule $it")
//            }, {
//                error.value = true
//            })

//        matchResultService.withDelay()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "delay $it")
//            }, {
//                error.value = true
//            })

//        matchResultService.withConcat()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "concat $it")
//            }, {
//                error.value = true
//            })

//        matchResultService.withSwitch()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "switch $it")
//            }, {
//                error.value = true
//            })
    }

    //TODO: implementation without bindings
//    fun createView() {
//        itemsCall = womenWorldCupAPI.getTeamsResult()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                items.value = it
//            },{
//                error.value = true
//            })
//    }

    override fun onCleared() {
        super.onCleared()
        itemsCall?.dispose()
    }
}
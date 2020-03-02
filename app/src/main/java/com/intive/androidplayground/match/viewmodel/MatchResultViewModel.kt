package com.intive.androidplayground.match.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intive.androidplayground.match.model.MatchResult
import com.intive.androidplayground.match.model.api.service.MatchResultService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MatchResultViewModel(matchResultService: MatchResultService) : ViewModel() {

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
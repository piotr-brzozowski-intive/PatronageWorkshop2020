package com.intive.androidplayground.match.view

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.intive.androidplayground.match.model.MatchResult

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(
    recyclerView: RecyclerView,
    items: MutableLiveData<List<MatchResult>>
) {
    if (recyclerView.adapter is MatchResultListAdapter) {
        items.value?.let {
            (recyclerView.adapter as MatchResultListAdapter).updateMatchResults(it)
        }
    }
}
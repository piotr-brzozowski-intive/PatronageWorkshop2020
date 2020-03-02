package com.intive.androidplayground.match.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.intive.androidplayground.R
import com.intive.androidplayground.match.model.MatchResult

class MatchResultListAdapter :
    ListAdapter<MatchResult, MatchResultViewHolder>(MatchResultDiffCallback()) {

    private val matchResults = mutableListOf<MatchResult>()


    override fun onBindViewHolder(holder: MatchResultViewHolder, position: Int) {
        holder.bindTo(matchResults[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MatchResultViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.match_result_view, parent, false)
    )

    override fun getItemCount() = matchResults.size

    fun updateMatchResults(matchResults: List<MatchResult>) {
        this.matchResults.clear()
        this.matchResults.addAll(matchResults)
        notifyDataSetChanged()
    }
}
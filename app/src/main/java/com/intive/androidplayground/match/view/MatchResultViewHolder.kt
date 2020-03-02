package com.intive.androidplayground.match.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.intive.androidplayground.match.model.MatchResult
import kotlinx.android.synthetic.main.match_result_view.view.*

class MatchResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(matchResult: MatchResult) {
        with(itemView) {
            header.text = matchResult.groupLetter.toString()
            details.text = StringBuilder()
                .append(matchResult).toString()
        }
    }
}
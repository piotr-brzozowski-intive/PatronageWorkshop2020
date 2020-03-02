package com.intive.androidplayground.match.view

import androidx.recyclerview.widget.DiffUtil
import com.intive.androidplayground.match.model.MatchResult

class MatchResultDiffCallback : DiffUtil.ItemCallback<MatchResult>() {
    override fun areItemsTheSame(oldItem: MatchResult, newItem: MatchResult) = oldItem == newItem

    override fun areContentsTheSame(oldItem: MatchResult, newItem: MatchResult) = oldItem == newItem
}
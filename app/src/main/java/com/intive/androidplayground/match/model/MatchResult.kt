package com.intive.androidplayground.match.model

import com.squareup.moshi.Json

data class MatchResult(
    val id: Int,
    val country: String,
    val alternateName: String?,
    @Json(name = "fifa_code") val fifa_code: String,
    @Json(name = "group_id") val groupId: Int,
    @Json(name = "group_letter") val groupLetter: Char,
    val wins: Int,
    val draws: Int,
    val losses: Int
)
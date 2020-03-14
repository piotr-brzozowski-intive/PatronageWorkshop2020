package com.intive.androidplayground.match.model

import com.squareup.moshi.Json

data class Match(val venue: String, val location: String, val status: String, val winner: String, val attendance: String, @Json(name = "home_team_country") val homeTeamCountry: String, @Json(name = "away_team_country")val awayTeamCountry: String)
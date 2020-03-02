package com.intive.androidplayground.di

import com.intive.androidplayground.match.model.api.repository.LocalMatchResultRepository
import com.intive.androidplayground.match.model.api.repository.MatchResultRepositoryAPI
import com.intive.androidplayground.match.model.api.service.MatchResultService
import com.intive.androidplayground.match.view.MatchResultListAdapter
import com.intive.androidplayground.match.viewmodel.MatchResultViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val matchModule = module {

    single<MatchResultRepositoryAPI> { LocalMatchResultRepository() }

    single { MatchResultService(get(), get()) }

    factory { MatchResultListAdapter() }

    viewModel { MatchResultViewModel(get()) }
}
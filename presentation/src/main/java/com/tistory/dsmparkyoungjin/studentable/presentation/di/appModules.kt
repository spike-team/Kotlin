package com.tistory.dsmparkyoungjin.studentable.presentation.di

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val appModules = module {

    single { CompositeDisposable() }
}
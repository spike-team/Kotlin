package com.tistory.dsmparkyoungjin.studentable.presentation.di

import com.tistory.dsmparkyoungjin.studentable.presentation.ui.splash.SplashContract
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.splash.SplashPresenter
import org.koin.dsl.module

val presenterModules = module {

    factory<SplashContract.Presenter> { SplashPresenter(get(), get()) }
}
package com.tistory.dsmparkyoungjin.studentable.presentation.di

import com.tistory.dsmparkyoungjin.domain.usecase.SetUseCase
import org.koin.dsl.module

val useCaseModules = module {

    factory { SetUseCase(get()) }
}
package com.tistory.dsmparkyoungjin.studentable.presentation.di

import com.tistory.dsmparkyoungjin.domain.service.SetService
import org.koin.dsl.module

val serviceModules = module {

    factory<SetService> { }
}
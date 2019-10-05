package com.tistory.dsmparkyoungjin.studentable

import android.app.Application
import com.tistory.dsmparkyoungjin.studentable.presentation.di.appModules
import com.tistory.dsmparkyoungjin.studentable.presentation.di.presenterModules
import com.tistory.dsmparkyoungjin.studentable.presentation.di.serviceModules
import com.tistory.dsmparkyoungjin.studentable.presentation.di.useCaseModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class StudenTableApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@StudenTableApplication)
            module { listOf(
                    appModules,
                    presenterModules,
                    serviceModules,
                    useCaseModules
            ) }
        }
    }
}
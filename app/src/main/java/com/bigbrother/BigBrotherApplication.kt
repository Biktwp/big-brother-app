package com.bigbrother

import android.app.Application
import com.bigbrother.data.di.dataBaseModule
import com.bigbrother.data.di.dataSourceModule
import com.bigbrother.domain.di.repositoryModule
import com.bigbrother.domain.di.useCaseModule
import com.bigbrother.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class BigBrotherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BigBrotherApplication)
            val moduleList =
                listOf(
                    viewModelModule,
                    dataBaseModule,
                    dataSourceModule,
                    repositoryModule,
                    useCaseModule
                )
            loadKoinModules(moduleList)
        }
    }
}
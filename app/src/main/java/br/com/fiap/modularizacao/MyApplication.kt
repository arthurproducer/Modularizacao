package br.com.fiap.modularizacao

import android.app.Application
import br.com.fiap.data.di.dataModules
import br.com.fiap.domain.di.domainModule
import br.com.fiap.modularizacao.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            modules(domainModule + dataModules + listOf(presentationModule))
        }
    }
}


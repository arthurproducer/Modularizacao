package br.com.fiap.modularizacao.di

import br.com.fiap.modularizacao.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {

    viewModel { MainViewModel(
        useCase = get(),
        uiScheduler = AndroidSchedulers.mainThread()
    )
    }
}


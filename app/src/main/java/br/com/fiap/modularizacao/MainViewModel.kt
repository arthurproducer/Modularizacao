package br.com.fiap.modularizacao

import androidx.lifecycle.MutableLiveData
import br.com.fiap.domain.entity.Product
import br.com.fiap.domain.usecases.GetProductsUseCase
import br.com.fiap.modularizacao.viewmodel.BaseViewModel
import br.com.fiap.modularizacao.viewmodel.StateMachineSingle
import br.com.fiap.modularizacao.viewmodel.ViewState
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign


class MainViewModel(
    val useCase: GetProductsUseCase,
    val uiScheduler: Scheduler
): BaseViewModel() {

    val state = MutableLiveData<ViewState<List<Product>>>().apply {
        value = ViewState.Loading
    }

    fun getProducts(forceUpdate: Boolean = false) {
        disposables += useCase.execute(forceUpdate = forceUpdate)
            .compose(StateMachineSingle())
            .observeOn(uiScheduler)
            .subscribe(
                {
                    //onSuccess
                    state.postValue(it)
                },
                {
                    //onError
                }
            )
    }
}

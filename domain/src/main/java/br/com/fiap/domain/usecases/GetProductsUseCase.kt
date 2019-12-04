package br.com.fiap.domain.usecases

import br.com.fiap.domain.entity.Product
import br.com.fiap.domain.repository.ProductRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class GetProductsUseCase (
    private val productRepository: ProductRepository,
    private val scheduler: Scheduler
){
    fun  execute(forceUpdate: Boolean) : Single<List<Product>>{
        return productRepository.getProducts(forceUpdate)
            .observeOn(scheduler)
    }
}
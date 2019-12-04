package br.com.fiap.domain.repository

import br.com.fiap.domain.entity.Product
import io.reactivex.Single

interface ProductRepository {

    fun getProducts(forceUpdate : Boolean) : Single<List<Product>>
}
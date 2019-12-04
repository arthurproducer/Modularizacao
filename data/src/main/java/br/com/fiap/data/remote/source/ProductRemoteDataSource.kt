package br.com.fiap.data.remote.source

import br.com.fiap.domain.entity.Product
import io.reactivex.Single

interface ProductRemoteDataSource {

    fun getProducts() : Single<List<Product>>
}
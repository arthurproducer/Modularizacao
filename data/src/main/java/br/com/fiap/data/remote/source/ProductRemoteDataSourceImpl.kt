package br.com.fiap.data.remote.source

import br.com.fiap.data.remote.api.ProductAPI
import br.com.fiap.data.remote.mapper.ProductPayloadMapper
import br.com.fiap.domain.entity.Product
import io.reactivex.Single

class ProductRemoteDataSourceImpl (private val productAPI: ProductAPI)  : ProductRemoteDataSource {
    override fun getProducts(): Single<List<Product>> {
        return productAPI.getProducts().map { ProductPayloadMapper.map(it) }
    }

}
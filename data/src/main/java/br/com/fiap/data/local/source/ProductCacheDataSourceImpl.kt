package br.com.fiap.data.local.source

import ProductCacheMapper
import br.com.fiap.data.local.database.ProductDao
import br.com.fiap.domain.entity.Product
import io.reactivex.Single

class ProductCacheDataSourceImpl (
    private val productDao: ProductDao
) : ProductCacheDataSource{
    override fun getProducts(): Single<List<Product>> {
        return productDao.getProducts().map { ProductCacheMapper.map(it) }
    }

    override fun insertData(products: List<Product>) {
        return productDao.insertAll(ProductCacheMapper.mapProductToProductCache(products))
    }

    override fun updateData(products: List<Product>) {
        return productDao.insertAll(ProductCacheMapper.mapProductToProductCache(products))
    }

}
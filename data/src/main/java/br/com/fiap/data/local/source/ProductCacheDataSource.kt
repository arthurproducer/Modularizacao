package br.com.fiap.data.local.source

import android.provider.ContactsContract
import br.com.fiap.domain.entity.Product
import io.reactivex.Single

interface ProductCacheDataSource {

    fun getProducts() : Single<List<Product>>

    fun insertData(products : List<Product>)

    fun updateData(products : List<Product>)
}
package br.com.fiap.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import br.com.fiap.data.local.model.ProductCache
import io.reactivex.Single

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getProducts(): Single<List<ProductCache>>

    @Transaction
    fun updateData(products: List<ProductCache>) {
        deleteAll()
        insertAll(products)
    }

    @Insert
    fun insertAll(products: List<ProductCache>)

    @Query("DELETE FROM products")
    fun deleteAll()
}


package br.com.fiap.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.data.local.model.ProductCache


@Database(version = 1, entities = [ProductCache::class])
abstract class ProductDataBase: RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        fun createDataBase(context: Context): ProductDao {
            return Room
                .databaseBuilder(context, ProductDataBase::class.java, "Products.db")
                .build()
                .productDao()
        }
    }
}


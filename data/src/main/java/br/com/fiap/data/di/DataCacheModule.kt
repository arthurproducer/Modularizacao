package br.com.fiap.data.di

import br.com.fiap.data.local.database.ProductDataBase
import br.com.fiap.data.local.source.ProductCacheDataSource
import br.com.fiap.data.local.source.ProductCacheDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheDataModule = module{
    single { ProductDataBase.createDataBase(androidContext()) }
    factory<ProductCacheDataSource> { ProductCacheDataSourceImpl(productDao = get()) }
}
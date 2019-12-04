package br.com.fiap.data.di

import br.com.fiap.data.repository.ProductRepositoryImpl
import br.com.fiap.domain.repository.ProductRepository
import org.koin.dsl.module
import remoteDataSourceModule

val repositoryModule = module {
    factory<ProductRepository> {
        ProductRepositoryImpl(
            productCacheDataSource = get(),
            productRemoteDataSource = get()
        )
    }
}

val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)

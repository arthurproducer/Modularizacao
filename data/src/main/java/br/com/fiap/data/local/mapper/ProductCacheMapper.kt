import br.com.fiap.data.local.model.ProductCache
import br.com.fiap.domain.entity.Product

object ProductCacheMapper {

    fun map(cacheData: List<ProductCache>) = cacheData.map { map(it) }

    private fun map(productCache: ProductCache) = Product(
        name = productCache.name,
        imageURL = productCache.imageURL,
        description = productCache.description
    )

    fun mapProductToProductCache(products : List<Product>) = products.map { map(it) }

    private fun map(product: Product) = ProductCache(
        name = product.name,
        imageURL = product.imageURL,
        description = product.description
    )
}

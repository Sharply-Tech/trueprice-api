package tech.sharply.trueprice.api.persistence.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import tech.sharply.trueprice.api.persistence.models.ProductCategory

@Repository
interface ProductCategoryRepository : MongoRepository<ProductCategory, String> {
    fun findByCode(code: String): ProductCategoryRepository?
}
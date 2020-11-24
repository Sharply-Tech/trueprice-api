package tech.sharply.trueprice.api.persistence.repositories

import org.springframework.data.domain.Page
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import tech.sharply.trueprice.api.persistence.models.Product
import tech.sharply.trueprice.api.persistence.models.ProductCategory
import org.springframework.data.domain.Pageable
import java.util.*

@Repository
interface ProductRepository : MongoRepository<Product, String> {

    fun findByUuid(uuid: UUID): Optional<Product>

    fun findByCategory(category: ProductCategory, pageable: Pageable): Page<Product>
}
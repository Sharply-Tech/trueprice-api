package tech.sharply.trueprice.api.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import tech.sharply.trueprice.api.persistence.models.Product
import tech.sharply.trueprice.api.persistence.repositories.ProductCategoryRepository
import tech.sharply.trueprice.api.persistence.repositories.ProductRepository
import java.util.*

@RestController
@RequestMapping("/api/products")
class ProductsController(
        @Autowired
        private val productRepository: ProductRepository,
        @Autowired
        private val categoryRepository: ProductCategoryRepository
) {

    @GetMapping
    fun findAll(pageable: Pageable) = productRepository.findAll(pageable)


    @GetMapping("/{id}")
    fun findOne(@PathVariable id: UUID) = productRepository.findByUuid(id).get()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This product does not exist!")

    @GetMapping("/categories/{categoryCode}")
    fun findByCategory(@PathVariable categoryCode: String, pageable: Pageable): Page<Product> {
        val category = categoryRepository.findByCode(categoryCode)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Products category not found!")

        return productRepository.findByCategory(category, pageable);
    }


}

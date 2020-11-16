package tech.sharply.trueprice.api.controllers

import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import tech.sharply.trueprice.api.persistence.repositories.ProductRepository

@RestController
@RequestMapping("/api/products")
class ProductsController(
        private val productRepository: ProductRepository
) {

    @GetMapping
    fun findAll(pageable: Pageable) = productRepository.findAll(pageable)

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: String) = productRepository.findById(id).get()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")

}

package tech.sharply.trueprice.api.services

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import tech.sharply.trueprice.api.persistence.models.Product
import tech.sharply.trueprice.api.persistence.repositories.ProductRepository

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScrapersServiceTest(@Autowired val scrapersService: ScrapersService,
                          @Autowired val productRepository: ProductRepository) {

    @Test
    fun `Products fetch by string platform code and string category code`() {
        val products: List<ScrapersService.BasicPlatformProductInfo> = scrapersService.getProducts("emag", "laptopuri", 1)
        assert(products.isNotEmpty())
    }

//    @Test
//    fun `Products fetch and save into the database`() {
//        val products: List<ScrapersService.BasicPlatformProductInfo> = scrapersService.getProducts("emag", "laptopuri", 1)
//        for (productInfo in products) {
//            var product = Product()
//            product.title = productInfo.title
//
//            productRepository.save(product)
//        }
//    }
}
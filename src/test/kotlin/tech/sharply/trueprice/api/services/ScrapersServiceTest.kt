package tech.sharply.trueprice.api.services

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScrapersServiceTest(@Autowired val scrapersService: ScrapersService) {

    @Test
    fun `Products fetch by string platform code and string category code`() {

        val products: List<ScrapersService.BasicPlatformProductInfo> = scrapersService.getProducts("emag", "laptopuri", 1)
        assert(products.isNotEmpty())
    }
}
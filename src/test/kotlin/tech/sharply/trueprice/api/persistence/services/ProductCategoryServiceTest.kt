package tech.sharply.trueprice.api.persistence.services

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class ProductCategoryServiceTest(
        @Autowired val productCategoryServiceTest: ProductCategoryService
) {

    @Test
    fun configureSystemProductCategories() {
        productCategoryServiceTest.configureSystemProductCategories();
    }
}
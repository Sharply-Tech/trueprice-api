package tech.sharply.trueprice.api.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import tech.sharply.trueprice.api.env.ScrapersServiceConf
import tech.sharply.trueprice.api.persistence.models.ProductCategory
import tech.sharply.trueprice.api.persistence.models.platforms.Platform
import tech.sharply.trueprice.api.persistence.repositories.ProductRepository
import tech.sharply.trueprice.api.persistence.repositories.platforms.PlatformRepository
import java.math.BigDecimal

@Service
class ScrapersService(
        @Autowired val scrapersServiceConf: ScrapersServiceConf,
        @Autowired val productRepository: ProductRepository,
        @Autowired val platformRepository: PlatformRepository,
        @Autowired val restTemplate: RestTemplate
) {


    fun getProducts(
            platform: Platform,
            category: ProductCategory,
            pageIndex: Int
    ): List<BasicPlatformProductInfo> {
        // TODO: solve the platform category
        var response = restTemplate.getForEntity(scrapersServiceConf.baseUrl!!.toURI()
                .resolve("/products/${platform.code}/${category.code}/page/${pageIndex}"),
                PageResponse::class.java)

        return response.body!!.products
    }

    fun getProducts(
            platform: String,
            category: String,
            pageIndex: Int
    ): List<BasicPlatformProductInfo> {
        var response = restTemplate.getForEntity(scrapersServiceConf.baseUrl!!.toURI()
                .resolve("/products/${platform}/${category}/page/${pageIndex}"),
                PageResponse::class.java)

        return response.body!!.products
    }

    data class BasicPlatformProductInfo(
            val title: String,
            val url: String,
            val price: BigDecimal,
            val oldPrice: BigDecimal? = null
    )

    data class PageResponse(
            val category: String,
            val products: List<BasicPlatformProductInfo>
    )

}
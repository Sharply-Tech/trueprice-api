package tech.sharply.trueprice.api.services

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import tech.sharply.trueprice.api.env.ScrapersServiceConf
import tech.sharply.trueprice.api.persistence.models.ProductCategory
import tech.sharply.trueprice.api.persistence.repositories.ProductRepository
import tech.sharply.trueprice.api.persistence.repositories.platforms.PlatformRepository

/**
 * Service that automatically indexes new products and updates offers for existing ones
 */
@Service
class ProductsCatalogIndexService(
        @Autowired val scrapersService: ScrapersService
) {

    private val _log = LoggerFactory.getLogger(ProductsCatalogIndexService::class.java)

    @Scheduled(fixedDelay = 5000)
    fun index() {
        _log.info("Indexing products...");
        // fetch products for last 3
        _log.info("Products indexed!")
    }

    /**
     * Indexes the products for a given category.
     */
    fun index(category: ProductCategory) {
        _log.info("Indexing products for category " + category.code)

        // fetch the products from all registered scrapers for this category

        _log.info("Products indexed for category " + category.code)
    }

}
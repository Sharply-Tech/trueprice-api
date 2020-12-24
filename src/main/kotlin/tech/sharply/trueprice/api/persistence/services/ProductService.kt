package tech.sharply.trueprice.api.persistence.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import tech.sharply.trueprice.api.persistence.models.Product
import tech.sharply.trueprice.api.persistence.models.ProductCategory
import tech.sharply.trueprice.api.persistence.models.platforms.Platform
import tech.sharply.trueprice.api.persistence.models.platforms.PlatformProductOffer
import tech.sharply.trueprice.api.persistence.repositories.ProductRepository
import tech.sharply.trueprice.api.persistence.repositories.platforms.PlatformProductOfferRepository
import tech.sharply.trueprice.api.services.ScrapersService

@Service
class ProductService(
        @Autowired
        private val productRepository: ProductRepository,
        @Autowired
        private val platformProductOfferRepository: PlatformProductOfferRepository
) {

    /**
     * Identifies a registered product offer using basic product info.
     */
    fun identifyOffer(info: ScrapersService.BasicPlatformProductInfo, platform: Platform): PlatformProductOffer? {
        // check if there is any offer registered with this url
        val offer = platformProductOfferRepository.findByPlatformAndUrl(platform, info.url);
        if (offer.isEmpty) {
            return null
        }
        return offer.get()
    }

    /**
     * Identifies the best product match for a given scraped title.
     * If there is no match then the product is not registered into our system.
     */
    fun identifyProduct(productTitle: String, category: ProductCategory): Product {
        // FIXME: Algoritmul ce urmeaza a fi implementat a fost dezvoltat pe baza exemplelor din categorie telefoane mobile
        // FIXME: Cel mai bine s-ar preta ceva pe Text Analysis in acest caz. https://monkeylearn.com/text-analysis/
    // FIXME: Ar trebui dezvoltat ceva pe baza de AI ca sa se faca totul cat mai bine
        // TODO: Remove keywords related to the category from the title

        // TODO: Identify the manufacturer
        // TODO: extract the product name, remove specifications

    }

}